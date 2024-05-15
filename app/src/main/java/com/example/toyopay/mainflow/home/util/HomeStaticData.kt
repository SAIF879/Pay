package com.example.toyopay.mainflow.home.util

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector

data class HomeStaticData(
    val image : ImageVector = Icons.Default.AccountCircle,
    val phoneNumber : String?,
    val name : String?,
    val timeStamp : String?,
    val amount : String?,
    val status : String?,
)

val testDataList = listOf(
    HomeStaticData(
        phoneNumber = "+1-123-456-7890",
        name = "John Doe",
        timeStamp = "2024-05-15 10:30:00",
        amount = "100 USD",
        status = "Paid"
    ),
    HomeStaticData(
        phoneNumber = "+44-987-654-3210",
        name = "Jane Smith",
        timeStamp = "2024-05-15 11:45:00",
        amount = "75 USD",
        status = "Unpaid"
    ),
    HomeStaticData(
        phoneNumber = "+91-555-555-5555",
        name = "Alice Johnson",
        timeStamp = "2024-05-15 09:00:00",
        amount = "200 USD",
        status = "Paid"
    ),
    HomeStaticData(
        phoneNumber = "+86-777-777-7777",
        name = "Bob Brown",
        timeStamp = "2024-05-15 13:20:00",
        amount = "50 USD",
        status = "Unpaid"
    ),
    HomeStaticData(
        phoneNumber = "+33-999-999-9999",
        name = "Emily Davis",
        timeStamp = "2024-05-15 15:00:00",
        amount = "150 USD",
        status = "Paid"
    ),
    HomeStaticData(
        phoneNumber = "+7-111-111-1111",
        name = "Michael Wilson",
        timeStamp = "2024-05-15 16:45:00",
        amount = "25 USD",
        status = "Unpaid"
    ),
    HomeStaticData(
        phoneNumber = "+52-333-333-3333",
        name = "Sarah Martinez",
        timeStamp = "2024-05-15 14:10:00",
        amount = "300 USD",
        status = "Paid"
    ),
    HomeStaticData(
        phoneNumber = "+49-666-666-6666",
        name = "David Taylor",
        timeStamp = "2024-05-15 12:15:00",
        amount = "80 USD",
        status = "Unpaid"
    ),
    HomeStaticData(
        phoneNumber = "+81-444-444-4444",
        name = "Olivia Anderson",
        timeStamp = "2024-05-15 17:30:00",
        amount = "120 USD",
        status = "Paid"
    ),
    HomeStaticData(
        phoneNumber = "+82-222-222-2222",
        name = "Christopher Thomas",
        timeStamp = "2024-05-15 18:00:00",
        amount = "40 USD",
        status = "Unpaid"
    )
)
