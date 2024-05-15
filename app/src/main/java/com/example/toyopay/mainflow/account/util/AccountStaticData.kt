package com.example.toyopay.mainflow.account.util

data class AccountStaticData(
    val heading : String
)

val accountStaticList = listOf(
AccountStaticData(heading = "Profile"),
    AccountStaticData(heading = "Upload Documents"),
    AccountStaticData(heading = "Account Settings"),
    AccountStaticData(heading = "About TayoPay"),
    AccountStaticData(heading = "Terms & Conditions"),
    AccountStaticData(heading = "Privacy Policy"),
    AccountStaticData(heading = "Complaint Policy"),
    AccountStaticData(heading = "Version"),
)