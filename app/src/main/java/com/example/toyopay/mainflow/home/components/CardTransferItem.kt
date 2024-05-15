package com.example.toyopay.mainflow.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toyopay.mainflow.home.util.HomeStaticData
import com.example.toyopay.ui.theme.White

@Composable
fun CardTransferItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp), colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxSize()) {

            }
            HorizontalDivider()
        }
    }
}

@Composable
private fun CardPersonalDetails(modifier: Modifier , details : HomeStaticData){
Column (modifier = modifier){

}
}

@Composable
private fun CardTransactionDetails(modifier: Modifier){

}