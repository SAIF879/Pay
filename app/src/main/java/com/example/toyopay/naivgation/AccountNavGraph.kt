package com.example.toyopay.naivgation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.accountNavGraph(navController: NavController){

    navigation(
        route = NavGraphs.ACCOUNT,
        startDestination = AccountScreens.ProfileScreen.route
    ) {
        composable(route = SplashScreens.SplashScreen.route) {
//            Splashscreen(navController)
        }


    }

}
sealed class AccountScreens(val route:String){

   data object ProfileScreen : SplashScreens(route = "profile_screen")
}