package com.example.task.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme

@Composable
fun DailyLogsDetails(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {


            LogDetailsCard(navController)
            LogDetailsCard(navController,R.drawable.pending)
            LogDetailsCard(navController)
            LogDetailsCard(navController)

        }
    }


@Composable
fun LogDetailsCard(navController: NavHostController,image: Int =  R.drawable.active){
    Card(  modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        .clickable { navController.navigate(NavigationScreen.DailyScreen.route) },
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceAround ) {
            Image(
                painter = painterResource(id = R.drawable.calender),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.Top)
            )
            
            Column(
                Modifier
                    .width(IntrinsicSize.Max)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)) {
                Text(text = "1  gallon de leche",modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),fontSize = 20.sp)

                Divider(color = Color.Gray, modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp))

                Text(text = "236.20 RD\$",modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),fontSize = 14.sp)
            }

            Image(
                painter = painterResource(id = image),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(top = 20.dp, start = 20.dp)
            )
            

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    TaskTheme {
        val navController = rememberNavController()
        DailyLogsDetails(navController)
    }
}