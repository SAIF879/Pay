package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.authentication.components.GenerateFillUpBox
import com.example.toyopay.mainflow.authentication.components.GeneratePhoneNumberBox
import com.example.toyopay.naivgation.Login
import com.example.toyopay.networkServices.data.LoginRequestBody
import com.example.toyopay.ui.theme.LightBlue
import com.example.toyopay.ui.theme.NavyBlue

@Composable
fun LoginScreen(navController: NavController,
                putUserDetails: (Login) -> Unit
) {

    var phoneNumber = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    val visibilityGone = remember {
        mutableStateOf(true)
    }

    fun areFieldsValid(
        phoneNumber: String,
        password: String,
    ): Boolean {
        return phoneNumber.isNotEmpty() && password.isNotEmpty()
    }

    val isValid = areFieldsValid(
        phoneNumber = phoneNumber.value,
        password = password.value,
    )

    TayoPayBackground {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Column(
                modifier = Modifier.weight(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 10.dp) , verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Start) {
                    TayoPayTexts.TextAsAbsoluteBlack(text = "Log In" , color = NavyBlue)
                }
                TayoPayTexts.TextAsMedium(
                    text = "Enter Your Mobile Number And PassWord",
                    color = LightBlue
                )
                Spacer(modifier = Modifier.size(5.dp))
                GeneratePhoneNumberBox(phoneNumber = phoneNumber)
                GenerateFillUpBox(
                    detailText = password,
                    placeHolder = "PassWord",
                    trailingIcon = if (visibilityGone.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    visualTransformation =if (visibilityGone.value) PasswordVisualTransformation() else VisualTransformation.None
                ) {
                    visibilityGone.value=!visibilityGone.value

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    TayoPayTexts.TextAsExtraLight(text = "Forgot Password?")

                }

            }
            Column(
                modifier = Modifier.weight(0.5f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GenerateFunctionalButton(text = "Login" , isEnabled =isValid ){
                    putUserDetails(Login.LoginDetails(LoginRequestBody(
                        username = "27${phoneNumber.value}",
                        password = password.value
                    )))


                }

                TayoPayTexts.TextAsExtraLight(text = "Don't have an account ? Sign Up")
            }

        }
    }
}

