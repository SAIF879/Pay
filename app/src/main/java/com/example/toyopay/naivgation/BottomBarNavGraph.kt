package com.example.toyopay.naivgation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toyopay.mainflow.account.ui.AccountScreen
import com.example.toyopay.mainflow.account.util.AccountViewModel
import com.example.toyopay.mainflow.bottombar.util.BottomBarScreen
import com.example.toyopay.mainflow.home.ui.HomeScreen
import com.example.toyopay.mainflow.transfer.ui.TransferScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {

    val accountViewModel : AccountViewModel = hiltViewModel()
    val state=accountViewModel.accountStates.collectAsState().value
    LaunchedEffect(key1 = Unit) {
        accountViewModel.fetchUserDetails()
    }


    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()

        }
        composable(route = BottomBarScreen.Transfer.route) {

            TransferScreen()
        }
        composable(route = BottomBarScreen.Account.route) {
            AccountScreen(navHostController, state)
        }

        accountNavGraph(navHostController  , state)


    }
}
