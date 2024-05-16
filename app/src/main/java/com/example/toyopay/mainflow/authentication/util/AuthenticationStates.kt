package com.example.toyopay.mainflow.authentication.util

import com.example.toyopay.networkServices.ApiResult
import com.example.toyopay.networkServices.data.DetailsUserResponse
import com.example.toyopay.networkServices.data.LoginUserResponse
import com.example.toyopay.networkServices.data.RegisterUserResponse

data class AuthenticationStates(
    val  registerDetails : ApiResult<RegisterUserResponse>?=null,
    val loginDetails : ApiResult<LoginUserResponse>? = null
)

