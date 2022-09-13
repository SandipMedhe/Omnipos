package com.example.task.presentation.business_details

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.component.Button
import com.example.task.component.InputText
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BusinessDetailsScreen(navController: NavHostController) {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var nameHasError by remember { mutableStateOf(false) }
    var nameLabel by remember { mutableStateOf("Enter your name") }

    var type by remember { mutableStateOf("") }
    var typeHasError by remember { mutableStateOf(false) }
    var typeLabel by remember { mutableStateOf("Enter tipo") }


    var owner by remember { mutableStateOf("") }
    var ownerHasError by remember { mutableStateOf(false) }
    var ownerLabel by remember { mutableStateOf("Enter tipo") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Andy Rubin",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 30.dp)
        )

        Text(
            text = stringResource(id = R.string.busseness_details),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))
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

        Text(
            text = stringResource(id = R.string.tipo),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )
        InputText(
            text = type, label = typeLabel, onTextChange = {
                type = it
            }, isError = typeHasError, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.Dueña),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )

        InputText(
            text = owner, label = ownerLabel, onTextChange = {
                owner = it
            }, isError = ownerHasError, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Button(
                text = "Previous", onClick = { },
                modifier = Modifier
                    .weight(0.2f)
                    .padding(10.dp)


            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                text = "Continuar", onClick = {
                    when {
                        name.isEmpty() -> {
                            nameHasError = true
                            nameLabel = "Name cannot be empty"
                        }
                        type.isEmpty() -> {
                            typeHasError = true
                            typeLabel = "tipo cannot be empty"
                        }
                        owner.isEmpty() -> {
                            ownerHasError = true
                            ownerLabel = "Name cannot be empty"
                        }
                        else -> {
                            Toast.makeText(context, "Moving to the next Page", Toast.LENGTH_SHORT)
                                .show()
                            navController.navigate(NavigationScreen.BusinessAddressScreen.route)
                        }
                    }
                },
                modifier = Modifier
                    .weight(0.2f)
                    .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 15.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TaskTheme {
        val navController = rememberNavController()
        BusinessDetailsScreen(navController)
    }
}

