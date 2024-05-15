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
    val iconFilled: ImageVector,
    val iconOutlined: ImageVector,

    ) {
   data object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        iconFilled = Icons.Filled.Home,
        iconOutlined = Icons.Outlined.Home
    )

  data  object Transfer : BottomBarScreen(
        route = "transfer",
        title = "Transfer",
        iconFilled = Icons.Filled.Checklist,
        iconOutlined = Icons.Outlined.Checklist
    )

    data object Account : BottomBarScreen(
        route = "account",
        title = "Account",
        iconFilled = Icons.Filled.AccountCircle,
        iconOutlined = Icons.Outlined.AccountCircle
    )
}