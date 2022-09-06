package com.example.task.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@Composable
fun DailyLogsDetails() {
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { }
                .clip(RoundedCornerShape(10.dp)),
            backgroundColor = Color.Transparent
        ) {

            Text(
                text = stringResource(id = R.string.Registros_diarios),
                fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
                modifier = Modifier
                    .padding(top = 10.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    TaskTheme {
        DailyLogsDetails()
    }
}