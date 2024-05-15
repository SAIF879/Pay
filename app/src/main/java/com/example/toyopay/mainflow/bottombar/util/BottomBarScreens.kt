package com.example.toyopay.mainflow.bottombar.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Checklist
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val iconOutlined: ImageVector,

    ) {
   data object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        iconOutlined = Icons.Outlined.Home
    )

  data  object Transfer : BottomBarScreen(
        route = "transfer",
        title = "Transfer",
        iconOutlined = Icons.Outlined.Checklist
    )

    data object Account : BottomBarScreen(
        route = "account",
        title = "Account",
        iconOutlined = Icons.Outlined.AccountCircle
    )
}