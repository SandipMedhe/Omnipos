package com.example.task.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.presentation.component.Button
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor


@Composable
fun DailyLogs(navController: NavHostController) {

    val voiceText = remember {
        mutableStateOf("")
    }



    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(), horizontalAlignment = CenterHorizontally) {

        TopAppBar(
            backgroundColor = AppColor.buttonColor,
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))

                Text(
                    text = stringResource(id = R.string.daily_logs),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.voice_logo),
            contentDescription = "voice logo",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )

        Text(
            text = stringResource(id = R.string.toque_el),
            fontSize = 24.sp,
            color = AppColor.textColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = voiceText.value, onValueChange = {
            voiceText.value = it
        }, maxLines = 10, modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .padding(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor =Color.Gray,
                cursorColor = Color.Gray,
                placeholderColor = Color.LightGray
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.la_entrada),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(30.dp)
                )
            })

        Button(
            text = stringResource(id = R.string.txt_continue),
            onClick = { navController.navigate(NavigationScreen.DailyLogsDetails.route) },
            modifier = Modifier
                .padding(top = 20.dp)
                .align(CenterHorizontally)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    TaskTheme {
        val navController = rememberNavController()
        DailyLogs(navController)
    }
}