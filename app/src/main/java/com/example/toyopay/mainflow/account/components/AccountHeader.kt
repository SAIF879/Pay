package com.example.toyopay.mainflow.account.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.networkServices.data.DetailsUserResponse
import com.example.toyopay.ui.theme.LightBlack
import com.example.toyopay.ui.theme.White


@Composable
fun AccountHeader(details: DetailsUserResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(70.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxSize()
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "account_img",
                        modifier = Modifier
                            .size(50.dp)
                    )
                    CardPersonalDetails(modifier = Modifier, details = details)
                }

                CardContactDetails(modifier = Modifier, details = details)


            }


        }
    }
}

@Composable
private fun CardPersonalDetails(modifier: Modifier, details: DetailsUserResponse) {
    Column(modifier = modifier) {
        TayoPayTexts.TextAsAbsoluteBlack(
            text = "${details.data?.firstName + details.data?.lastName}",
            color = LightBlack,
            fontsize = 13
        )
        TayoPayTexts.TextAsMedium(
            text = "Customer id: ${details.data?.id}",
            color = LightBlack,
            fontsize = 13
        )
    }
}

@Composable
private fun CardContactDetails(modifier: Modifier, details: DetailsUserResponse) {
    Column(modifier = modifier) {
        TayoPayTexts.TextAsMedium(
            text = "M ${details.data?.mobilePhone}",
            color = LightBlack,
            fontsize = 13
        )
        TayoPayTexts.TextAsMedium(
            text = "M ${details.data?.email}",
            color = LightBlack,
            fontsize = 13
        )
    }
}
