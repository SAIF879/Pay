package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayTexts

@Composable
fun SignUpScreen(navController: NavController) {
    TayoPayBackground{
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            item { TayoPayTexts.TextAsSubheading(text = "Sign in to TayoPay") }
            item { TayoPayTexts.TextAsSubheading(text = "Enter your details to create account") }
            item {
                GenerateFunctionalButton(text = "Continue"){}
            }
            item {
                Row (modifier = Modifier.fillMaxWidth().padding(10.dp)){
                    TayoPayTexts.TextAsHint(text = "By clicking on continue, I agree to TayoPay Terms & Privacy Policy")
                }
            }
        }
    }
}