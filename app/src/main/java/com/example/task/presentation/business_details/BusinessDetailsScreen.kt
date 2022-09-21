package com.example.task.presentation.business_details

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
fun BusinessDetailsScreen(navController: NavHostController
,viewModel: DetailsViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val businessName = stringResource(id = R.string.businessName)
    val strType = stringResource(id = R.string.typeLabel)
    val strOwnerLabel = stringResource(id = R.string.ownerLabel)
    val nextPageToast = stringResource(id = R.string.nextPageToast)
    val businessNameLabel = stringResource(id = R.string.bussinessNameLabel)
    val typeLabelNull = stringResource(id = R.string.typeLabelNull)
    val OwnerLabelNull = stringResource(id = R.string.OwnerLabelNull)


    var name = viewModel.businessName.value
    var nameHasError by remember { mutableStateOf(false) }
    var nameLabel by remember { mutableStateOf(businessName) }

    var type = viewModel.businessType.value
    var typeHasError by remember { mutableStateOf(false) }
    var typeLabel by remember { mutableStateOf(strType) }


    var owner = viewModel.businessOwner.value
    var ownerHasError by remember { mutableStateOf(false) }
    var ownerLabel by remember { mutableStateOf(strOwnerLabel) }



    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
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

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = R.string.bussiness_Name),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )
        InputText(
            text = name.text, label = nameLabel, onTextChange = {
                viewModel.onEvent(BusinessDetailsEvent.EnterName(it))
            }, isError = nameHasError, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.type),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )
        InputText(
            text = type.text, label = typeLabel, onTextChange = {
                viewModel.onEvent(BusinessDetailsEvent.EnteredType(it))
            }, isError = typeHasError, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.Owner),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            color = Color.Gray,
            fontSize = 15.sp, fontWeight = FontWeight.Bold
        )

        InputText(
            text = owner.text, label = ownerLabel, onTextChange = {
                viewModel.onEvent(BusinessDetailsEvent.EnteredOwner(it))
            }, isError = ownerHasError, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Button(
                text = stringResource(id = R.string.previous), onClick = {navController.popBackStack() },
                modifier = Modifier
                    .weight(0.2f)
                    .padding(10.dp)


            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                text = stringResource(id = R.string.txt_continue), onClick = {
                    when {
                        name.text.isEmpty() -> {
                            nameHasError = true
                            nameLabel = businessNameLabel
                        }
                        type.text.isEmpty() -> {
                            typeHasError = true
                            typeLabel = typeLabelNull
                        }
                        owner.text.isEmpty() -> {
                            ownerHasError = true
                            ownerLabel = OwnerLabelNull
                        }
                        else -> {
                            viewModel.onEvent(BusinessDetailsEvent.InsertUser)
                            Toast.makeText(context, nextPageToast, Toast.LENGTH_SHORT)
                                .show()
                            navController.navigate(NavigationScreen.BusinessAddressScreen.route)
                        }
                    }
                },
                modifier = Modifier
                    .weight(0.2f)
                    .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 15.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TaskTheme {
        val navController = rememberNavController()
        BusinessDetailsScreen(navController)
    }
}

