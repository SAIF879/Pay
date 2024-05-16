package com.example.toyopay.networkServices.data

import com.google.gson.annotations.SerializedName

data class RegisterUserResponse (

    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("data"    ) var data    : RegisterUserData?   = RegisterUserData(),
    @SerializedName("message" ) var message : String? = null

)

data class RegisterUserData (

    @SerializedName("id" ) var id : Int? = null

)