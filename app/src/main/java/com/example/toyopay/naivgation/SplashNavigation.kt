package com.example.toyopay.naivgation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.toyopay.mainflow.splash.ui.SplashScreen

fun NavGraphBuilder.splashNavGraph(navController: NavController) {

    navigation(
        route = NavGraphs.SPLASH,
        startDestination = SplashScreens.SplashScreen.route
    ) {
        composable(route = SplashScreens.SplashScreen.route) {
            SplashScreen(navController)
        }


    }

}

sealed class SplashScreens(val route: String) {

    data object SplashScreen : SplashScreens(route = "splash_screen")
}