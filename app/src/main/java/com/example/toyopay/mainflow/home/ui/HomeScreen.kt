package com.example.toyopay.mainflow.home.ui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.mainflow.home.components.CardTransferItem
import com.example.toyopay.mainflow.home.util.testDataList

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(White)) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().weight(0.1f).padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "Recent Transfers")
                Text(text = "See All")

            }

            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp),
                modifier = Modifier
                    .fillMaxWidth().weight(0.8f)
                    .padding(15.dp, 10.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize()
                ) {
                    items(testDataList) { item ->
                        CardTransferItem(details = item)
                    }
                }
            }
            GenerateFunctionalButton(modifier = Modifier.weight(0.1f))
            Spacer(modifier = Modifier.size(100.dp))
            
            
        }
    }
}