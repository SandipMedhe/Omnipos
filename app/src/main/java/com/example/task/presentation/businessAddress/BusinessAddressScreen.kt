package com.example.task.presentation.businessAddress

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
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
import com.example.task.presentation.component.Button
import com.example.task.presentation.component.InputText
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BusinessAddressScreen(navController: NavHostController,
                          viewModel: AddressViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val cityStr = stringResource(id = R.string.city)
    val pinStr = stringResource(id = R.string.city_pin)
    val add1 = stringResource(id = R.string.add_1)
    val add2 = stringResource(id = R.string.add_2)
    val cityNullTxt = stringResource(id = R.string.cityNullTxt)
    val cityPinNull = stringResource(id = R.string.cityPinNull)
    val add1Null = stringResource(id = R.string.add_1_null)
    val add2Null = stringResource(id = R.string.add_2_null)
    val nextPageToast = stringResource(id = R.string.nextPageToast)

    var city = viewModel.addressCity.value
    var cityHasError by remember { mutableStateOf(false) }
    var cityLabel by remember { mutableStateOf(cityStr) }

    var cityPin = viewModel.addressPin.value
    var cityPinHasError by remember { mutableStateOf(false) }
    var cityPinLabel by remember { mutableStateOf(pinStr) }

    var direction1 = viewModel.addressDirectionOne.value
    var direction1HasError by remember { mutableStateOf(false) }
    var direction1Label by remember { mutableStateOf(add1) }

    var direction2 = viewModel. addressDirectionTwo.value
    var direction2HasError by remember { mutableStateOf(false) }
    var direction2Label by remember { mutableStateOf(add2) }




    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Abc",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 30.dp)
        )
        Text(
            text = stringResource(id = R.string.busseness_details),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        InputText(
            text = city.text,
            label = cityLabel,
            onTextChange = {
                viewModel.onEvent(BusinessAddressEvent.EnterCity(it))
            }, isError = cityHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = cityPin.text,
            label = cityPinLabel,
            onTextChange = {
                viewModel.onEvent(BusinessAddressEvent.EnterPin(it))
            }, isError = cityPinHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = direction1.text,
            label = direction1Label,
            onTextChange = {
                viewModel.onEvent(BusinessAddressEvent.EnteredAddressOne(it))
            }, isError = direction1HasError,
            modifier = Modifier

                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = direction2.text,
            label = direction2Label,
            onTextChange = {  viewModel.onEvent(BusinessAddressEvent.EnteredAddressTwo(it)) }, isError = direction2HasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        Button(
            text = stringResource(id = R.string.txt_continue), onClick = {
                when {
                    city.text.isEmpty() -> {
                        cityHasError = true
                        cityLabel = cityNullTxt
                    }
                    cityPin.text.isEmpty() -> {
                        cityPinHasError = true
                        cityPinLabel = cityPinNull
                    }
                    direction1.text.isEmpty() -> {
                        direction1HasError = true
                        direction1Label = add1Null
                    }
                    direction2.text.isEmpty() -> {
                        direction2HasError = true
                        direction1Label = add2Null
                    }
                    else -> {
                        viewModel.onEvent(BusinessAddressEvent.InsertAddress)
                        viewModel.onEvent(BusinessAddressEvent.GetAllDAta)
                        Toast.makeText(context, nextPageToast, Toast.LENGTH_SHORT)
                            .show()
                        navController.navigate(NavigationScreen.DashBoard.route)
                    }
                }
            },
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
        val navController = rememberNavController()
        BusinessAddressScreen(navController)
    }
}