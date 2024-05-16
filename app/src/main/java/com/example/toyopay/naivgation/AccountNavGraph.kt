package com.example.toyopay.naivgation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.toyopay.mainflow.account.ui.ProfileScreen
import com.example.toyopay.mainflow.account.util.AccountStates

fun NavGraphBuilder.accountNavGraph(
    navController: NavController,
    state: AccountStates,
){

    navigation(
        route = NavGraphs.ACCOUNT,
        startDestination = AccountScreens.ProfileScreen.route
    ) {


        composable(route = AccountScreens.ProfileScreen.route) {
               ProfileScreen(navController = navController)
        }


    }

}
sealed class AccountScreens(val route:String){

   data object ProfileScreen : SplashScreens(route = "profile_screen")
}