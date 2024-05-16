package com.example.toyopay.naivgation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
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
import com.example.toyopay.networkServices.ApiResult
import com.example.toyopay.networkServices.data.LoginRequestBody
import com.example.toyopay.networkServices.data.RegisterRequestBody
import com.example.toyopay.util.extentions.toast
import com.example.toyopay.util.sharedViewModel.sharedViewModel
import kotlinx.coroutines.async

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
            val authenticationViewModel = it.sharedViewModel<AuthenticationViewModel>(navController = navController)
            val state=authenticationViewModel.authenticationStates.collectAsState().value
            val context = LocalContext.current
            when(val signup = state.registerDetails){
                is ApiResult.Error -> {
                    context.toast("${signup.message}")
                }
                ApiResult.Loading -> {

                }
                is ApiResult.Success -> {
                    LaunchedEffect(key1 = Unit) {
                        navController.navigate(AuthenticationScreens.SuccessScreen.route)
                    }

                }
                null -> Unit
            }
            SignUpScreen(navController){details ->
                when(details){
                    is SignUp.SignUpDetails -> {
                        authenticationViewModel.registerUser(details.data)
                    }
                }

            }
        }
        composable(route = AuthenticationScreens.SuccessScreen.route) {
            SuccessScreen(navController)
        }
        composable(route = AuthenticationScreens.LoginScreen.route) {
            val context = LocalContext.current
            val authenticationViewModel = it.sharedViewModel<AuthenticationViewModel>(navController = navController)
            val state=authenticationViewModel.authenticationStates.collectAsState().value
            LoginScreen(navController){details->
                when(details){
                    is Login.LoginDetails ->{
                        authenticationViewModel.loginUser(details.data)
                        navController.navigate(NavGraphs.BOTTOM)

                    }
                }

            }
            when(val login=state.loginDetails){
                is ApiResult.Success->{
                    navController.navigate(NavGraphs.BOTTOM)
                }

                is ApiResult.Error -> {
                    context.toast("${login.message}")
                }
                ApiResult.Loading -> {

                }
                null -> Unit
            }
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

sealed class Login{
    data class LoginDetails(val data : LoginRequestBody) : Login()
}
