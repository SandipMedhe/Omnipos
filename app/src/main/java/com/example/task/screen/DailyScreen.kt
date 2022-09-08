package com.example.task.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor


@Composable
fun Daily(navController: NavHostController) {

    DailyCard(navController)

}

@Composable
fun DailyCard(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

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
                    text = stringResource(id = R.string.Daily),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.active),
                    contentDescription = "Andy Rubin",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
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

        Details()
    }
}


@Composable
fun Details() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),

        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = stringResource(id = R.string.Daily),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "Date", color = Color.Gray, fontSize = 24.sp)

                Text(
                    text = "28/07/2022-15:31",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
                    .width(1.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = stringResource(id = R.string.Purchased_items),
                    color = Color.Gray,
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(50.dp))
            }


            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp)
                    .width(1.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.one_gallon_milk),
                    color = Color.Black,
                    fontSize = 24.sp,
                )

            }


            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 15.dp)
                    .width(1.dp)
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    TaskTheme {
        val navController = rememberNavController()
        DailyCard(navController)
    }
}