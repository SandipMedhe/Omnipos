package com.example.task.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R
import com.example.task.component.Button
import com.example.task.component.InputText
import com.example.task.ui.theme.TaskTheme

@OptIn(ExperimentalComposeUiApi::class)

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(start = 10.dp, end = 10.dp),
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
            text = "", label = "", onTextChange = {}, modifier = Modifier
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
            text = "", label = "", onTextChange = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.Forgotpass),
            modifier = Modifier
                .padding(top = 10.dp, end = 20.dp)
                .fillMaxWidth()
                .clickable { },
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )



        Button(
            text = "Continuar", onClick = { },
            modifier = Modifier
                .padding(top = 30.dp, start = 50.dp, end = 50.dp).fillMaxWidth()
                .align(CenterHorizontally)
        )


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskTheme {
        LoginScreen()
    }
}