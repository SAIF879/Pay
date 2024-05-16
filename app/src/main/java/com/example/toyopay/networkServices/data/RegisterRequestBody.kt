package com.example.toyopay.networkServices.data

data class RegisterRequestBody(
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val email: String,
    val mobilePhone: String,
    val password: String,
    val genderId: Int,
    val dateOfBirth: String
)

