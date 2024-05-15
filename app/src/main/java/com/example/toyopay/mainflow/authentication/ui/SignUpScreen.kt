package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.authentication.components.BottomDisclaimer
import com.example.toyopay.mainflow.authentication.components.GenerateFillUpBox
import com.example.toyopay.mainflow.authentication.components.GeneratePhoneNumberBox
import com.example.toyopay.ui.theme.LightBlue

@Composable
fun SignUpScreen(navController: NavController) {
    var firstName = remember {
        mutableStateOf("")
    }
    var middleName = remember {
        mutableStateOf("")
    }
    var lastName = remember {
        mutableStateOf("")
    }
    var email = remember {
        mutableStateOf("")
    }
    var phoneNumber = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    var gender = remember {
        mutableStateOf("")
    }
    var dob = remember {
        mutableStateOf("")
    }
    TayoPayBackground{
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            item { Spacer(modifier = Modifier.size(20.dp)) }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(20.dp , 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TayoPayTexts.BlackText(
                        text = "Sign in to TayoPay",
                        color = Color.Black,
                        size = 20
                    )
                }
            }
            item {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(20.dp , 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    TayoPayTexts.TextAsSmallHeader(text = "Enter your details to create account" , color = LightBlue)
                }
            }
            item {
                GenerateFillUpBox( detailText =firstName , placeHolder ="First Name" )
            }
            item {
                GenerateFillUpBox( detailText =middleName , placeHolder ="Middle Name" )
            }
            item {
                GenerateFillUpBox( detailText =lastName , placeHolder ="Last Name" )
            }
            item {
                GenerateFillUpBox( detailText =email , placeHolder ="Email" )
            }
            item {
                GeneratePhoneNumberBox(phoneNumber = phoneNumber )
            }
            item {
                GenerateFillUpBox( detailText =gender , placeHolder ="Gender" )
            }
            item {
                GenerateFillUpBox( detailText =dob , placeHolder ="Date of Birth" )
            }
            item {
                GenerateFillUpBox( detailText =password , placeHolder ="Password" )
            }
            item {
                GenerateFunctionalButton(text = "Continue"){}
            }
            item {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp) , verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center){
                    BottomDisclaimer()
                }
            }
        }
    }
}