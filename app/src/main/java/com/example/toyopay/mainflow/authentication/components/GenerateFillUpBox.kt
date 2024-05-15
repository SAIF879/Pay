package com.example.toyopay.mainflow.authentication.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toyopay.ui.theme.LightBlack
import com.example.toyopay.ui.theme.LightGrey
import com.example.toyopay.ui.theme.NavyBlue
import com.example.toyopay.ui.theme.White
import com.example.toyopay.util.fonts.TayoPayFonts

@Composable
fun GenerateFillUpBox(
    detailText : MutableState<String>,
    placeHolder : String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
){
    Column() {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(20.dp, 10.dp)
                .border(1.dp, LightGrey, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = detailText.value,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 1.dp)
                    .align(Alignment.Center),
                onValueChange = { detailText.value = it },
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
                    Text(
                        text = placeHolder,
                        fontFamily = TayoPayFonts.extraLight,
                        fontSize = 16.sp
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = onAction,
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = TayoPayFonts.semiBold,
                    fontSize = 16.sp
                )
            )
        }
    }
}
