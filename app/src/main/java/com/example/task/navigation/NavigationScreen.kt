package com.example.task.navigation

sealed class NavigationScreen(var route:String){

    object LoginScreen: NavigationScreen("loginScreen")
    object BusinessDetailsScreen: NavigationScreen("businessDetailsScreen")
    object BusinessAddressScreen: NavigationScreen("businessAddressScreen")
    object DashBoard: NavigationScreen("dashboard")
    object DailyLogs:NavigationScreen("daily_logs")
    object DailyLogsDetails: NavigationScreen("dailyLogDetailsScreen")
    object DailyScreen: NavigationScreen("dailyScreen")

}
