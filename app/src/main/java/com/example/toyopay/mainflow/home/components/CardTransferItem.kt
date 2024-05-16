package com.example.toyopay.mainflow.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.home.util.HomeStaticData
import com.example.toyopay.ui.theme.LightBlack
import com.example.toyopay.ui.theme.LightBlue
import com.example.toyopay.ui.theme.White

@Composable
fun CardTransferItem(
    details: HomeStaticData
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(80.dp), colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = details.image,
                    contentDescription = "account_img",
                    modifier = Modifier
                        .weight(0.2f)
                        .height(70.dp)
                )
                CardPersonalDetails(modifier = Modifier.weight(0.5f), details = details)
                CardTransactionDetails(modifier = Modifier.weight(0.3f), details = details)
            }
        }
    }
}

@Composable
private fun CardPersonalDetails(modifier: Modifier, details: HomeStaticData) {
    Column(modifier = modifier) {
        TayoPayTexts.TextAsMedium(
            details.phoneNumber ?: "NULL",
            color = LightBlack,
            fontsize = 13
        )
        TayoPayTexts.TextAsSemiBold(text = details.name ?: "NULL", color = Color.Black, fontSize = 17)
        TayoPayTexts.TextAsMedium(
            text = details.timeStamp ?: "NULL",
            color = LightBlack,
            fontsize = 13
        )
    }
}

@Composable
private fun CardTransactionDetails(modifier: Modifier, details: HomeStaticData) {
    Column(modifier = modifier.padding(10.dp , 0.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TayoPayTexts.TextAsMedium("cash collection", color = LightBlack, fontsize = 13)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TayoPayTexts.TextAsMedium(
                text = details.amount ?: "NULL",
                color = Color.Black,
                fontsize = 17
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TayoPayTexts.TextAsAbsoluteBlack(
                text = details.status ?: "NULL",
                color = LightBlue,
                fontsize = 13
            )
        }
    }
}