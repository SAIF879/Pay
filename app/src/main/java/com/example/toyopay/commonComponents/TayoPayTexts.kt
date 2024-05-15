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
    fun TextAsSmallHeader(text: String = "test", fontsize : Int = 17, modifier: Modifier = Modifier, color: Color = Black) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.medium,
                fontSize = fontsize.sp,
                color = color
            ), textAlign = TextAlign.Center , modifier = modifier
        )
    }

    @Composable
    fun TextAsSubheading(text: String, color : Color = Black, size:Int= 20, modifier: Modifier = Modifier) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.semiBold,
                fontSize = size.sp,
                color = color
            ), textAlign = TextAlign.Center, modifier = modifier
        )
    }


    @Composable
    fun TextAsHint(text: String , color: Color = Black) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.extraLight,
                fontSize = 12.sp,
                color = color
            ), textAlign = TextAlign.Start, maxLines = 1
        )
    }

    @Composable
    fun MainButtonText(text: String , color: Color = White) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.semiBold,
                fontSize = 18.sp,
                color = color
            ), textAlign = TextAlign.Start, maxLines = 1
        )
    }

    @Composable
    fun SubButtonText(text: String , color: Color = White) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.semiBold,
                fontSize = 10.sp,
                color = color
            ), textAlign = TextAlign.Start, maxLines = 1
        )
    }

    @Composable
    fun BlackText(text: String, color: Color = White, size: Int = 18, maxLines: Int = 1, modifier: Modifier = Modifier ) {
        Text(
            text = text, style = TextStyle(
                fontFamily = TayoPayFonts.black,
                fontSize = size.sp,
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
            TayoPayTexts.TextAsSmallHeader(text = "small header", color = White)
            TayoPayTexts.TextAsSubheading(text = " sub heading" , color = White)
            TayoPayTexts.TextAsHint(text = "hint" , color = White)
            TayoPayTexts.MainButtonText(text = "main button")
            TayoPayTexts.SubButtonText(text = " sub button")
            TayoPayTexts.BlackText(text = " bottom bar")
        }

    }
}