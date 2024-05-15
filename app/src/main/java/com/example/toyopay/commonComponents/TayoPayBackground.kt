package com.example.toyopay.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyopay.R
@Preview
@Composable
fun TayoPayBackground( content: @Composable () -> Unit = {}){
Box(modifier = Modifier.fillMaxSize()){
    Image(
        painter = painterResource(id = R.drawable.bg_tayopay),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}
}