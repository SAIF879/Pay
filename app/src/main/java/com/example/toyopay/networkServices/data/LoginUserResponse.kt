package com.example.toyopay.networkServices.data

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(


@SerializedName("status"  ) var status  : String? = null,
@SerializedName("data"    ) var data    : LoginData?   = LoginData(),
@SerializedName("message" ) var message : String? = null

)

data class LoginData (

    @SerializedName("authToken"    ) var authToken    : String? = null,
    @SerializedName("refreshToken" ) var refreshToken : String? = null

)