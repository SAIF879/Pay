package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.authentication.components.GeneratePhoneNumberBox

@Composable
fun LoginScreen() {
    TayoPayBackground {
        Column(modifier = Modifier.fillMaxSize()) {

            GenerateFunctionalButton("Login") {

            }
            TayoPayTexts.TextAsHint(text = "Don't have an account ? Sign Up")
        }
    }
}