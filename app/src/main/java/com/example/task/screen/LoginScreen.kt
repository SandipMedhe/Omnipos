package com.example.task.screen

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.component.Button
import com.example.task.component.InputText
import com.example.task.datastore.StoreUser
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)

@Composable
fun LoginScreen(navController: NavHostController) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreUser(context)

    var name by remember { mutableStateOf("") }
    var nameHasError by remember { mutableStateOf(false) }
    var nameLabel by remember { mutableStateOf("Enter your name") }

    var password by remember { mutableStateOf("") }
    var passwordHasError by remember { mutableStateOf(false) }
    var passwordLabel by remember { mutableStateOf("Enter your password") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(start = 10.dp, end = 10.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Andy Rubin",
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
            text = name, label = nameLabel, onTextChange = {
                name = it
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
            text = password, label = passwordLabel,
            onTextChange = {
                password = it
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
            text = "Continuar",
            onClick = {
                when {
                    name.isEmpty() -> {
                        nameHasError = true
                        nameLabel = "Name cannot be empty"
                    }
                    password.isEmpty() -> {
                        passwordHasError = true
                        passwordLabel = "Invalid password"
                    }
                    else -> {
                        scope.launch {
                            dataStore.saveUser(name)
                        }
                        Toast.makeText(context, "Successfully Logged In", Toast.LENGTH_SHORT).show()
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

