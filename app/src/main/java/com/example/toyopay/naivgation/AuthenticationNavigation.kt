package com.example.toyopay.naivgation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.toyopay.mainflow.authentication.ui.GetStartedScreen
import com.example.toyopay.mainflow.authentication.ui.LoginScreen
import com.example.toyopay.mainflow.authentication.ui.SignUpScreen
import com.example.toyopay.mainflow.authentication.ui.SuccessScreen
import com.example.toyopay.mainflow.authentication.util.AuthenticationViewModel
import com.example.toyopay.networkServices.data.RegisterRequestBody

fun NavGraphBuilder.authenticationNavGraph(navController: NavController ) {



    navigation(
        route = NavGraphs.AUTHENTICATION,
        startDestination = AuthenticationScreens.GetStartedScreen.route
    )
    {
        composable(route = AuthenticationScreens.GetStartedScreen.route) {
            GetStartedScreen(navController)
        }
        composable(route = AuthenticationScreens.SignUpScreen.route) {
            val authenticationViewModel  : AuthenticationViewModel = hiltViewModel()
            SignUpScreen(navController){details ->
                when(details){
                    is SignUp.SignUpDetails -> {
                        authenticationViewModel.registerUser(details.data)
                        navController.navigate(AuthenticationScreens.SuccessScreen.route)
                    }
                }

            }
        }
        composable(route = AuthenticationScreens.SuccessScreen.route) {
            SuccessScreen(navController)
        }
        composable(route = AuthenticationScreens.LoginScreen.route) {
            LoginScreen(navController)
        }


    }

}

sealed class AuthenticationScreens(val route: String) {

    data object GetStartedScreen : SplashScreens(route = "get_started_screen")
    data object SignUpScreen : SplashScreens(route = "sign_up_screen")
    data object SuccessScreen : SplashScreens(route = "success_screen")
    data object LoginScreen : SplashScreens(route = "login_screen")


}

sealed class SignUp{
    data class SignUpDetails(val data : RegisterRequestBody) : SignUp()
}

