package com.example.task.sc

import android.content.Intent
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.task.R
import com.example.task.data.datastore.StoreUser
import com.example.task.navigation.NavigationScreen
/*import com.example.task.presentation.biometricAuth.BiometricPopUp*/
import com.example.task.ui.theme.TaskTheme
import com.example.task.util.AppColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController) {

    val context = LocalContext.current
    val dataStore = StoreUser(context)
    val savedEmail = dataStore.getUser.collectAsState(initial = "")
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }


    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        Log.e("TAG1", "SplashScreen: ", )
        delay(1000L)
        Log.e("TAG2", "SplashScreen: ", )
       if (savedEmail.value!!.isEmpty())
            navController.navigate(NavigationScreen.LoginScreen.route)
        else {
         //   navController.navigate(NavigationScreen.DashBoard.route)
           Log.e("TAG", "SplashScreen: ", )
           navController.navigate(NavigationScreen.BiometricPopUpScreen.route)
           //navController.navigate(NavigationScreen.LoginScreen.route)
          // context.startActivity(Intent(context, BiometricPopUp::class.java))


        }
    }

    // Image
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Abc",
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .padding()
        )

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp, fontWeight = FontWeight.Bold, color = AppColor.textColor,
            modifier = Modifier.padding()
        )

    }
}


suspend fun splashNavigation(){
    delay(1000)
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TaskTheme {
        val navController = rememberNavController()
        SplashScreen(navController)
    }
}