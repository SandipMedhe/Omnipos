package com.example.task.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R
import com.example.task.ui.theme.TaskTheme

/*
@Composable
fun Daily() {

}

*/

@Composable
fun DailyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Image(
                painter = painterResource(id = R.drawable.active),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.Top)
            )

            Column(
                Modifier
                    .width(IntrinsicSize.Max)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "1  gallon de leche", modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally), fontSize = 20.sp
                )

                Divider(
                    color = Color.Gray, modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                )

                Text(
                    text = "236.20 RD\$", modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally), fontSize = 14.sp
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    TaskTheme {
        DailyCard()
    }
}