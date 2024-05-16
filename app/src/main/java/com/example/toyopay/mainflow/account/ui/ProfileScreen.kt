package com.example.toyopay.mainflow.account.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.account.util.AccountStates
import com.example.toyopay.networkServices.ApiResult
import com.example.toyopay.ui.theme.LightBlack
import com.example.toyopay.ui.theme.LightBlue
import com.example.toyopay.ui.theme.LightGrey
import com.example.toyopay.ui.theme.NavyBlue
import com.example.toyopay.ui.theme.White

@Composable
fun ProfileScreen(navController: NavController, state: AccountStates) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .background(White)
    ) {
        when (val details =state.userDetails) {
            is ApiResult.Error -> TODO()
            ApiResult.Loading -> {
             CircularProgressIndicator(color = LightBlue , modifier = Modifier.align(Alignment.Center))
            }
            is ApiResult.Success -> {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            TayoPayTexts.TextAsAbsoluteBlack(text = "Profile", color = NavyBlue , fontsize = 25)
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.size(30.dp))
                    }
                    item {
                        details.data?.data?.firstName?.let { ProfileItemBox(heading = "First Name", details = it) }
                    }
                    item {
                        details.data?.data?.lastName?.let { ProfileItemBox(heading = "Last Name", details = it) }
                    }
                    item {
                        details.data?.data?.email?.let { ProfileItemBox(heading = "Email", details = it) }
                    }
                    item {
                        details.data?.data?.mobilePhone?.let { ProfileItemBox(heading = "Phone Number", details = it) }
                    }
                    item {
                        ProfileItemBox(heading = "Gender", details = "Male")
                    }
                }
            }

            null -> {}
        }

    }
}


@Composable
fun ProfileItemBox(heading : String , details : String ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = White),
    ){
        Column (Modifier.padding(10.dp)){
            TayoPayTexts.TextAsExtraLight(text = heading , color = LightBlack , fontSize = 14 )
            TayoPayTexts.TextAsMedium(text = details , color = Color.Black , fontsize = 18)
        }

    }
}