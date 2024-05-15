package com.example.toyopay.naivgation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toyopay.mainflow.bottombar.util.BottomBarScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {


//    val marketViewModel: MarketViewModel = hiltViewModel()
//    val searchViewModel: SearchViewModel = hiltViewModel()
//    val authenticationViewmodel :AuthenticationViewmodel = hiltViewModel()
//    val searchState = searchViewModel.searchState.collectAsState()
//    val settingsViewModel: SettingsViewModel = hiltViewModel()
//    val authenticationStates = authenticationViewmodel.authenticationState.collectAsState()
    val context= LocalContext.current

//    LaunchedEffect(key1 = navHostController) {
//        marketViewModel.getCurrentLocation(context)
//        Log.d("Check" , "${marketViewModel.getCurrentLocation(context)}")
//    }



    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {



//            val mainState = marketViewModel.mainState.collectAsState()
//            MarketScreen(
//                mainState,
//                navController = navHostController,
//                marketViewModel::onEvent
//            )


        }
        composable(route = BottomBarScreen.Transfer.route) {

//            val historyViewModel: HistoryViewModel = hiltViewModel()
//
//            LaunchedEffect(key1 = navHostController) {
//                historyViewModel.fetchHistoryDetails("user23")
//            }
//
//            val historyState = historyViewModel.historyState.collectAsState()
//            HistoryScreen(historyState ){click->
//                when(click){
//                    is HistoryScreenEvents.Delete -> {
////                       historyState.value.userId = click.id
////                       click.id?.let { it1 -> historyViewModel.clearHistoryData(it1) }
//                    }
//                }
//            }
        }
        composable(route = BottomBarScreen.Account.route) {
//            SearchScreen(    searchState) { query ->
//                when (query) {
//                    is Search.Query -> {
//                        searchState.value.city = query.search
//                        searchViewModel.fetchPriceDetails(query.search)
//                        searchViewModel.fetchMathematicalData(query.search)
//                        navHostController.navigate(NavGraphs.RESULT)
//                    }
//                }
//            }
//            searchViewModel.fetchFavouriteList("user23")
        }

//
//        settingsNavGraph(navHostController, settingsViewModel)
//        searchNavHGraph(navHostController, searchState)
//        authenticationNavGraph(navHostController , authenticationStates , authenticationViewmodel)


    }
}
