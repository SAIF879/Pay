package com.example.toyopay.mainflow.authentication.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.ui.theme.LightBlack
import com.example.toyopay.ui.theme.LightGrey
import com.example.toyopay.util.fonts.TayoPayFonts

@Composable
fun GeneratePhoneNumberBox(
    phoneNumber : MutableState<String>,
    limit : Int = 10,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(20.dp, 10.dp)
        .border(1.dp, LightGrey, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ){
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Text(
                text = "+27",
                textAlign = TextAlign.Center,
                fontFamily = TayoPayFonts.medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold,
                color = Black
            )
            Spacer(modifier = Modifier.width(10.dp))
            VerticalDivider(color = LightGrey , modifier = Modifier.padding(0.dp , 10.dp))
            Spacer(modifier = Modifier.width(5.dp))
            TextField(
                value = phoneNumber.value,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(bottom = 1.dp),
                onValueChange = { if (it.length <= limit) phoneNumber.value = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedContainerColor = Transparent,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    cursorColor = Black,
                    focusedTextColor = Black,
                    focusedPlaceholderColor = LightBlack,
                    unfocusedPlaceholderColor = LightBlack,

                    ),
                placeholder = {
                    TayoPayTexts.TextAsExtraLight(text = "0 00 00 00 00" , color = LightBlack)

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = onAction,
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = TayoPayFonts.medium,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.width(30.dp))
        }


    }
}
