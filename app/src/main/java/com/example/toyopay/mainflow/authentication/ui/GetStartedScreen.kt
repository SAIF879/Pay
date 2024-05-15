package com.example.toyopay.mainflow.authentication.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyopay.R
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayBackground
import com.example.toyopay.commonComponents.TayoPayIcon


@Preview
@Composable
fun GetStartedScreen(){
TayoPayBackground{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
            TayoPayIcon(icon = R.drawable.icon_tayo_pay)
        TayoPayIcon(icon = R.drawable.img_get)
        GenerateFunctionalButton{}

    }
}
}

@Composable
fun ElevatedCard(modifier: Modifier, content: @Composable () -> Unit = {}) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp, 5.dp, 0.dp, 0.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
    ) {

        content.invoke()
    }
}