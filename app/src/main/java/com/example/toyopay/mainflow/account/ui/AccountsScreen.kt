package com.example.toyopay.mainflow.account.ui

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.toyopay.commonComponents.GenerateFunctionalButton
import com.example.toyopay.commonComponents.TayoPayTexts
import com.example.toyopay.mainflow.account.components.AccountCardItem
import com.example.toyopay.mainflow.account.components.AccountHeader
import com.example.toyopay.mainflow.account.util.AccountStates
import com.example.toyopay.mainflow.account.util.accountStaticList
import com.example.toyopay.naivgation.NavGraphs
import com.example.toyopay.networkServices.ApiResult
import com.example.toyopay.networkServices.data.DetailsUserResponse
import com.example.toyopay.ui.theme.LightBlack
import com.example.toyopay.ui.theme.LightBlue
import com.example.toyopay.ui.theme.White

@Composable
fun AccountScreen(navController: NavController, state: AccountStates) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TayoPayTexts.TextAsAbsoluteBlack(text = "Account", color = Color.Black)
                }
            }
            item {
                Spacer(modifier = Modifier.size(30.dp))
            }
            item {

                when(state.userDetails){
                    is ApiResult.Error -> {
                        
                    }
                    ApiResult.Loading -> {
                       CircularProgressIndicator(color = LightBlue)
                    }
                    is ApiResult.Success -> {
                        state.userDetails.data?.let { AccountHeader(details = it) }
                    }
                    null -> Unit
                }


            }
            item { Spacer(modifier = Modifier.size(20.dp)) }
            items(accountStaticList) { item ->
                AccountCardItem(heading = item) {
                    Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
                    navController.navigate(NavGraphs.ACCOUNT)
                }
                Spacer(modifier = Modifier.size(10.dp))

            }
            item {
                GenerateFunctionalButton()
            }
            item {
                Spacer(modifier = Modifier.size(100.dp))
            }

        }

    }
}

