package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayTexts

@Composable
fun LoginScreen(navController: NavController) {
    TayoPayBackground {
        Column(modifier = Modifier.fillMaxSize()) {

            GenerateFunctionalButton("Login") {

            }
            TayoPayTexts.TextAsExtraLight(text = "Don't have an account ? Sign Up")
        }
    }
}