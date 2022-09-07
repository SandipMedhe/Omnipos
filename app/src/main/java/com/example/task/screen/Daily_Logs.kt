package com.example.task.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
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
import com.example.task.component.Button
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor


@Composable
fun DailyLogs(navController: NavHostController) {

    val voiceText = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.Registros_diarios),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier
                .padding(top = 10.dp)
                .align(CenterHorizontally)
        )

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
            text = "Continuar", onClick = {navController.navigate(NavigationScreen.DailyLogsDetails.route) },
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