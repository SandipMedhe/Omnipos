package com.example.task.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task.screen.*

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.LoginScreen.route){
        composable(NavigationScreen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(NavigationScreen.BusinessDetailsScreen.route) {
            BusinessDetailsScreen(navController = navController)
        }

        composable(NavigationScreen.BusinessAddressScreen.route) {
            BusinessAddressScreen(navController = navController)
        }

        composable(NavigationScreen.DashBoard.route) {
            DashBoard(navController = navController)
        }

        composable(NavigationScreen.DailyLogs.route) {
            DailyLogs(navController = navController)
        }

        composable(NavigationScreen.DailyLogsDetails.route) {
            DailyLogsDetails(navController = navController)
        }

        composable(NavigationScreen.DailyScreen.route) {
            Daily()
        }




    }
}