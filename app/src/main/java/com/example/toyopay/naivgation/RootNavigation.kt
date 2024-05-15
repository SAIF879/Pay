package com.example.toyopay.naivgation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toyopay.mainflow.bottombar.ui.BottomBarScreen

@Composable
fun RootNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = NavGraphs.ROOT,
        startDestination = NavGraphs.BOTTOM
    ) {
        splashNavGraph(navHostController)
       authenticationNavGraph(navHostController)
        composable(route = NavGraphs.BOTTOM) {
            BottomBarScreen()
        }






    }
}

object NavGraphs {
    const val ROOT = "root"
    const val SPLASH = "splash"
    const val AUTHENTICATION = "authentication"
    const val BOTTOM = "bottom"
    const val ACCOUNT = "account"


}