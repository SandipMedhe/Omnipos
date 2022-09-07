package com.example.task.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.component.Button
import com.example.task.component.InputText
import com.example.task.navigation.NavigationScreen
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BusinessAddressScreen(navController: NavHostController) {
    val context = LocalContext.current

    var cuida by remember { mutableStateOf("") }
    var cuidaHasError by remember { mutableStateOf(false) }
    var cuidadLabel by remember { mutableStateOf("cuidad") }

    var codigo by remember { mutableStateOf("") }
    var codigoHasError by remember { mutableStateOf(false) }
    var codigoLabel by remember { mutableStateOf("codigo Pin") }

    var DiectionLineOne by remember { mutableStateOf("") }
    var Direccion_Linea_1HasError by remember { mutableStateOf(false) }
    var DirectionLine_1_LABEL by remember { mutableStateOf("Direccion Linea 1") }

    var Direccion_Linea_2 by remember { mutableStateOf("") }
    var Direccion_Linea_2HasError by remember { mutableStateOf(false) }
    var Direccion_Linea_2Label by remember { mutableStateOf("Direccion Linea 2") }


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
            text = cuida,
            label = cuidadLabel,
            onTextChange = {
                           cuida =it
            }, isError = cuidaHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text = codigo,
            label =codigoLabel ,
            onTextChange = {}, isError = codigoHasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text =  DiectionLineOne,
            label =  DirectionLine_1_LABEL,
            onTextChange = {}, isError =  Direccion_Linea_1HasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        InputText(
            text =  Direccion_Linea_2,
            label =  Direccion_Linea_2Label,
            onTextChange = {}, isError = Direccion_Linea_2HasError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
        )

        Button(
            text = "Continuar", onClick = {
                when {
                    cuida.isEmpty() -> {
                        cuidaHasError = true
                        cuidadLabel = "cuida cannot be empty"
                    }
                    codigo.isEmpty() -> {
                        codigoHasError = true
                        codigoLabel = "codigo Pin cannot be empty"
                    }
                    DiectionLineOne.isEmpty() -> {
                        Direccion_Linea_1HasError = true
                        DirectionLine_1_LABEL = "Direccion Linea 1 cannot be empty"
                    }
                    Direccion_Linea_2.isEmpty() -> {
                        Direccion_Linea_2HasError = true
                        Direccion_Linea_2Label = "Direccion Linea 2 cannot be empty"
                    }
                    else -> {
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