package com.example.toyopay.mainflow.authentication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toyopay.ui.theme.White

@Composable
fun ElevatedCard(modifier: Modifier, content: @Composable () -> Unit = {}) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {

        content.invoke()
    }
}