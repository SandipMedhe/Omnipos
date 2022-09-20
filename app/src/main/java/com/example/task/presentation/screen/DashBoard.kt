package com.example.task.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.data.datastore.StoreUser
import com.example.task.navigation.NavigationScreen
import com.example.task.presentation.login.AddViewModel
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@Composable
fun DashBoard(navController: NavHostController,
              viewModel: AddViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val dataStore = StoreUser(context)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(AppColor.textColor),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TopAppBar(
            backgroundColor = AppColor.buttonColor,
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "Arrow Back",
                    tint = Color.White,
                    modifier = Modifier.clickable {

                    })
                Spacer(modifier = Modifier.width(100.dp))

                Text(
                    text = stringResource(id = R.string.Tablero_de_mandos),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

              /*  IconButton( onClick = {}) {
                    Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "")
                }*/
            }

        }


        Spacer(modifier = Modifier.height(150.dp))

        Card(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Column(
                modifier = Modifier.background(color = Color.White).padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Image(
                    painter = painterResource(id = R.drawable.stocks_growth),
                    contentDescription = "Andy Rubin",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )

                DashBoardCard(
                    image = R.drawable.booklet,
                    text = stringResource(id = R.string.Registros_diarios),
                    onClick = {
                        navController.navigate(NavigationScreen.DailyLogs.route)
                    })

                DashBoardCard(
                    image = R.drawable.cart,
                    text = stringResource(id = R.string.Colecciones),
                    onClick = {

                    })

                DashBoardCard(
                    image = R.drawable.chart,
                    text = stringResource(id = R.string.Registros_diarios),
                    onClick = {


                    })
            }
        }
    }

}


@Composable
fun DashBoardCard(
    modifier: Modifier = Modifier,
    image: Int,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() }
            .clip(RoundedCornerShape(10.dp)),
        //set background color of the card
        backgroundColor = AppColor.textColor
    ) {

        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .width(60.dp)
                    .height(70.dp)
                    .padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .align(CenterVertically),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    TaskTheme {
        val navController = rememberNavController()
        DashBoard(navController)
    }
}