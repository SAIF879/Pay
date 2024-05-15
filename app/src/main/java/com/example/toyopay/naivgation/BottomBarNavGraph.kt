package com.example.toyopay.naivgation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toyopay.mainflow.account.ui.AccountScreen
import com.example.toyopay.mainflow.bottombar.util.BottomBarScreen
import com.example.toyopay.mainflow.home.ui.HomeScreen
import com.example.toyopay.mainflow.transfer.ui.TransferScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {



    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()

        }
        composable(route = BottomBarScreen.Transfer.route) {

            TransferScreen()
        }
        composable(route = BottomBarScreen.Account.route) {

            AccountScreen(navHostController)
        }

        accountNavGraph(navHostController)


    }
}
