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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.ui.theme.NavyBlue
import com.example.toyopay.ui.theme.White
import com.example.toyopay.util.fonts.TayoPayFonts

@Composable
fun GeneratePhoneNumberBox(
    phoneNumber : MutableState<String>,
    horizontalPadding : Int,
    verticalPadding : Int,
    limit : Int = 10,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(horizontalPadding.dp, verticalPadding.dp)
        .border(1.dp, Gray, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ){
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Text(
                text = " +91",
                textAlign = TextAlign.Center,
                fontFamily = TayoPayFonts.medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold,
                color = White
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = phoneNumber.value,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(bottom = 1.dp),
                onValueChange = { if (it.length <= limit) phoneNumber.value = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Cyan,
                    unfocusedContainerColor = Cyan,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = NavyBlue,
                    focusedTextColor = Black,
                    focusedPlaceholderColor = White,
                    unfocusedPlaceholderColor = White,

                    ),
                placeholder = {
                    TayoPayTexts.TextAsHint(text = "Enter Phone Number" , color = White)

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
