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
import com.example.task.navigation.component.Button
import com.example.task.navigation.component.InputText
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BusinessAddressScreen(navController: NavHostController,
                          viewModel: AddressViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var cuida = viewModel.addressCity.value
    var cuidaHasError by remember { mutableStateOf(false) }
    var cuidadLabel by remember { mutableStateOf("cuidad") }

    var codigo = viewModel.addressPin.value
    var codigoHasError by remember { mutableStateOf(false) }
    var codigoLabel by remember { mutableStateOf("codigo Pin") }

    var DiectionLineOne = viewModel.addressDirectionOne.value
    var Direccion_Linea_1HasError by remember { mutableStateOf(false) }
    var DirectionLine_1_LABEL by remember { mutableStateOf("Direccion Linea 1") }

    var Direccion_Linea_2 = viewModel. addressDirectionTwo.value
    var Direccion_Linea_2HasError by remember { mutableStateOf(false) }
    var Direccion_Linea_2Label by remember { mutableStateOf("Direccion Linea 2") }




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
            contentDescription = "Andy Rubin",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 30.dp)
        )
        Text(
            text = stringResource(id = R.string.Dirección),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        InputText(
            text = cuida.text,
            label = cuidadLabel,
            onTextChange = {
                viewModel.onEvent(BusinessAddressEvent.EnterCity(it))
            }, isError = cuidaHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = codigo.text,
            label = codigoLabel,
            onTextChange = {
                viewModel.onEvent(BusinessAddressEvent.EnterPin(it))
            }, isError = codigoHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = DiectionLineOne.text,
            label = DirectionLine_1_LABEL,
            onTextChange = {
                viewModel.onEvent(BusinessAddressEvent.EnteredAddressOne(it))
            }, isError = Direccion_Linea_1HasError,
            modifier = Modifier

                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = Direccion_Linea_2.text,
            label = Direccion_Linea_2Label,
            onTextChange = {  viewModel.onEvent(BusinessAddressEvent.EnteredAddressTwo(it)) }, isError = Direccion_Linea_2HasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        Button(
            text = "Continuar", onClick = {
                when {
                    cuida.text.isEmpty() -> {
                        cuidaHasError = true
                        cuidadLabel = "cuida cannot be empty"
                    }
                    codigo.text.isEmpty() -> {
                        codigoHasError = true
                        codigoLabel = "codigo Pin cannot be empty"
                    }
                    DiectionLineOne.text.isEmpty() -> {
                        Direccion_Linea_1HasError = true
                        DirectionLine_1_LABEL = "Field 1 cannot be empty"
                    }
                    Direccion_Linea_2.text.isEmpty() -> {
                        Direccion_Linea_2HasError = true
                        Direccion_Linea_2Label = "Field cannot be empty"
                    }
                    else -> {
                        viewModel.onEvent(BusinessAddressEvent.InsertAddress)
                        viewModel.onEvent(BusinessAddressEvent.GetAllDAta)
                        Toast.makeText(context, "Moving to the next Page", Toast.LENGTH_SHORT)
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