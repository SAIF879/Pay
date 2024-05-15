package com.example.toyopay.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TayoPayIcon(icon: Int ,size :Int = 40, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier.size(size.dp)
    )
}