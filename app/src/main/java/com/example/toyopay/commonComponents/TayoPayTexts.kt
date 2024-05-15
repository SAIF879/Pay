package com.example.toyopay.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.toyopay.ui.theme.White
import com.example.toyopay.util.fonts.TayoPayFonts

object TayoPayTexts{


    @Composable
    fun TextAsBoldHeader(text: String, color: Color = White, size : Int = 32, maxLines: Int = 1){
        Text(text = text, style = TextStyle(
            fontFamily = TayoPayFonts.interBold,
            fontSize = size.sp,
            color = color
        ) , textAlign = TextAlign.Center , maxLines = maxLines)
    }

    @Composable
    fun TextAsSemiBold(text:String , color: Color = White , fontSize: Int = 15 ){
        Text(text = text, style = TextStyle(
            fontFamily = TayoPayFonts.semiBold,
            fontSize = fontSize.sp,
            color = color
        ) , textAlign = TextAlign.Center ,)
    }

    @Composable
    fun TextAsMedium(text: String = "test", fontsize : Int = 17, modifier: Modifier = Modifier, color: Color = Black) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.medium,
                fontSize = fontsize.sp,
                color = color
            ), textAlign = TextAlign.Center , modifier = modifier
        )
    }
    @Composable
    fun TextAsExtraLight(text: String, color: Color = Black) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.extraLight,
                fontSize = 12.sp,
                color = color
            ), textAlign = TextAlign.Start, maxLines = 1
        )
    }


    @Composable
    fun TextAsAbsoluteBlack(text: String, color: Color = White, fontsize: Int = 18, maxLines: Int = 1, modifier: Modifier = Modifier ) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.black,
                fontSize = fontsize.sp,
                color = color
            ), textAlign = TextAlign.Start, maxLines = maxLines, modifier=modifier
        )
    }

}

@Preview
@Composable
fun TextsPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TayoPayTexts.TextAsBoldHeader(text = "bold header")
            TayoPayTexts.TextAsMedium(text = "small header", color = White)
            TayoPayTexts.TextAsExtraLight(text = "hint" , color = White)
            TayoPayTexts.TextAsAbsoluteBlack(text = " bottom bar")
            TayoPayTexts.TextAsSemiBold(text = "sadasdsadsa")
        }

    }
}