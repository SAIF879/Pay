package com.example.toyopay.mainflow.account.util

import com.example.toyopay.networkServices.ApiResult
import com.example.toyopay.networkServices.data.DetailsUserResponse

data class AccountStates(
    val  userDetails : ApiResult<List<DetailsUserResponse>>?=null,
)