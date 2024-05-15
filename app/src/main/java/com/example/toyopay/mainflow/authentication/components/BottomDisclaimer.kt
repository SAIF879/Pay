package com.example.toyopay.mainflow.authentication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toyopay.ui.theme.LightBlue
import com.example.toyopay.ui.theme.NavyBlue
import com.example.toyopay.ui.theme.White
import com.example.toyopay.util.fonts.TayoPayFonts

@Composable
fun BottomDisclaimer(){
    Row(
        modifier = Modifier.padding(7.dp , 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Spacer(modifier = Modifier.width(0.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = TayoPayFonts.extraLight , color = LightBlue, fontSize = 10.sp)) {
                    append("By clicking on continue, I agree to TayoPay ")
                }
                withStyle(style = SpanStyle(fontFamily = TayoPayFonts.extraLight  , color = Color.Black, fontSize = 10.sp)) {
                    append("Terms ")
                }
                withStyle(style = SpanStyle(fontFamily = TayoPayFonts.extraLight ,color = LightBlue, fontSize = 10.sp)) {
                    append("& ")
                }
                withStyle(style = SpanStyle(fontFamily = TayoPayFonts.extraLight ,color = Color.Black, fontSize = 10.sp)) {
                    append("Privacy Policy")
                }
            },
            Modifier.align(Alignment.CenterVertically),
            fontSize = 8.sp,

            )
    }
}