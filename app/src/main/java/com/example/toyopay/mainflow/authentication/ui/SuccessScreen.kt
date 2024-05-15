package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.ui.theme.NavyBlue


@Composable
fun SuccessScreen(navController: NavController) {
    TayoPayBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TayoPayTexts.TextAsBoldHeader("SignUp Success !!" , color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            TayoPayTexts.TextAsSmallHeader(text = "Your account has been \n created successfully" , color = NavyBlue)
            Spacer(modifier = Modifier.height(30.dp))
            GenerateFunctionalButton("Login"){

            }

        }
    }
}