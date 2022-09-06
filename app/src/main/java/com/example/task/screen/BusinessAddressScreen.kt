package com.example.task.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R
import com.example.task.component.Button
import com.example.task.component.InputText
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BusinessAddressScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.Dirección),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        InputText(
            text = "",
            label = stringResource(id = R.string.cuidad),
            onTextChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = "",
            label = stringResource(id = R.string.codigo),
            onTextChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = "",
            label = stringResource(id = R.string.Direccion_Linea_1),
            onTextChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = "",
            label = stringResource(id = R.string.Direccion_Linea_2),
            onTextChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        Button(
            text = "Continuar", onClick = { },
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    TaskTheme {
        BusinessAddressScreen()
    }
}