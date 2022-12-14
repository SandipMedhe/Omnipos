package com.example.task.presentation.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.presentation.component.Button
import com.example.task.presentation.component.InputText
import com.example.task.data.datastore.StoreUser
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: AddViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreUser(context)
    val enterName = stringResource(R.string.Enter_your_name)
    val enterPass = stringResource(R.string.enterPass)
    val emptyTxtErr = stringResource(id = R.string.emptyTxtErr)
    val invalidTxt = stringResource(R.string.invalid)
    val successMsg = stringResource(id = R.string.successMsg)

    var name = viewModel.userName.value
    var nameHasError by remember { mutableStateOf(false) }
    var nameLabel by remember { mutableStateOf(enterName) }

    var password = viewModel.passWord.value
    var passwordHasError by remember { mutableStateOf(false) }
    var passwordLabel by remember { mutableStateOf(enterPass) }

    Log.e("TAG", "LoginScreen: ", )


    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .background(color = Color.White)
            .padding(start = 10.dp, end = 10.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Abc",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .align(CenterHorizontally)
                .padding(bottom = 30.dp)
        )

        Text(
            text = stringResource(id = R.string.Name),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )

        InputText(
            text = name.text, label = nameLabel, onTextChange = {
                viewModel.onEvent(AddEvent.EnterName(it))
            }, isError = nameHasError, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )

        InputText(
            text = password.text, label = passwordLabel,
            onTextChange = {
                viewModel.onEvent(AddEvent.EnteredPassword(it))
            },
            isError = passwordHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            visualTransformation = PasswordVisualTransformation()

        )

        Text(
            text = stringResource(id = R.string.Forgotpass),
            modifier = Modifier
                .padding(top = 20.dp, end = 30.dp)
                .fillMaxWidth()
                .clickable { },
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )



        Button(
            text = stringResource(id = R.string.txt_continue),
            onClick = {
                when {
                    name.text.isEmpty() -> {
                        nameHasError = true
                        nameLabel = emptyTxtErr
                    }
                    password.text.isEmpty() -> {
                        passwordHasError = true
                        passwordLabel = invalidTxt
                    }
                    else -> {
                        scope.launch {
                            dataStore.saveUser(name.text)
                            viewModel.onEvent(AddEvent.InsertUser)
                        }
                        Toast.makeText(context, successMsg, Toast.LENGTH_SHORT).show()
                        navController.navigate(NavigationScreen.BusinessDetailsScreen.route)
                    }
                }
            },
            modifier = Modifier
                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .align(CenterHorizontally)
        )


    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}

