package com.example.toyopay.mainflow.splash.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import com.example.toyopay.R
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayIcon
import com.example.toyopay.naivgation.NavGraphs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview
@Composable
fun SplashScreen(navController: NavController = NavController(LocalContext.current)) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    splashNavigation(coroutineScope , navController , context)
    TayoPayBackground {
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TayoPayIcon(icon = R.drawable.icon_tayo_pay, size = 200)
        }
    }
}

fun splashNavigation(coroutineScope: CoroutineScope, navController: NavController , context: Context){
    coroutineScope.launch {
        delay(2000)
        navController.navigate(NavGraphs.AUTHENTICATION)
    }
}
