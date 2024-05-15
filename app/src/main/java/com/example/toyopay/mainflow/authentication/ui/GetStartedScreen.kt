package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyopay.R
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayIcon
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.authentication.components.ElevatedCard
import com.example.toyopay.ui.theme.NavyBlue
import com.example.toyopay.ui.theme.White


@Preview
@Composable
fun GetStartedScreen() {
    TayoPayBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TayoPayIcon(icon = R.drawable.icon_tayo_pay , size = 150)
                TayoPayIcon(icon = R.drawable.img_get , size = 200)
                GenerateFunctionalButton(text = "Check Rates" ) {}
            }
            ElevatedCard(modifier = Modifier.weight(0.4f)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TayoPayTexts.TextAsBoldHeader(
                        text = "Send Money \n With Just Few Clicks",
                        color = NavyBlue,
                        maxLines = 2
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    GenerateFunctionalButton {}
                    GenerateFunctionalButton(text = "I hava an account") {}


                }
            }
        }
    }
}

