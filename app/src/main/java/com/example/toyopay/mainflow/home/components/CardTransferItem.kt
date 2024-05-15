package com.example.toyopay.mainflow.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toyopay.commonComponents.TayoPayIcon
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.home.util.HomeStaticData
import com.example.toyopay.ui.theme.White

@Composable
fun CardTransferItem(details: HomeStaticData) {
    Card(
        modifier = Modifier
            .fillMaxWidth().padding(5.dp)
            .height(100.dp), colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxSize()) {
            TayoPayIcon(icon = details.image , modifier = Modifier.weight(1f))
                CardPersonalDetails(modifier = Modifier.weight(1f), details =details )
                CardTransactionDetails(modifier = Modifier.weight(1f), details =details )
            }
            HorizontalDivider()
        }
    }
}

@Composable
private fun CardPersonalDetails(modifier: Modifier , details : HomeStaticData){
Column (modifier = modifier){
TayoPayTexts.TextAsSmallHeader(details.phoneNumber?:"NULL")
    TayoPayTexts.BlackText(text = details.name?:"NULL")
    TayoPayTexts.TextAsSmallHeader(text = details.timeStamp?:"NULL")
}
}

@Composable
private fun CardTransactionDetails(modifier: Modifier , details : HomeStaticData){
    Column (modifier = modifier){
        TayoPayTexts.TextAsSmallHeader("cash collection")
        TayoPayTexts.BlackText(text = details.amount?:"NULL")
        TayoPayTexts.TextAsSmallHeader(text = details.status?:"NULL")
    }
}