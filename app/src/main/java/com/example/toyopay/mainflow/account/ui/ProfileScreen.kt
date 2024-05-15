package com.example.toyopay.mainflow.account.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.ui.theme.NavyBlue
import com.example.toyopay.ui.theme.White

@Composable
fun ProfileScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp).background(White)){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    TayoPayTexts.TextAsMedium(text = "Profile", color = NavyBlue)
                }
            }

        }
    }
}