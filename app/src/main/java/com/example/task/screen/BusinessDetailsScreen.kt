package com.example.task.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun BusinessDetailsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.busseness_details),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = stringResource(id = R.string.Name), modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            fontSize = 30.sp, color = AppColor.textColor
        )

        InputText(
            text = "", label = "", onTextChange = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp).clip(RoundedCornerShape(50))
        )

        Text(
            text = stringResource(id = R.string.tipo), modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(10.dp)),
            fontSize = 30.sp, color = AppColor.textColor
        )

        InputText(
            text = "", label = "", onTextChange = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Text(
            text = stringResource(id = R.string.Dueña), modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(10.dp)),
            fontSize = 30.sp, color = AppColor.textColor
        )

        InputText(
            text = "", label = "", onTextChange = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Button(
            text = "Continuar", onClick = {  },
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TaskTheme {
        BusinessDetailsScreen()
    }
}

