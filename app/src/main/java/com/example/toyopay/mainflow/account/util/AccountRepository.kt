package com.example.toyopay.mainflow.account.util

import com.example.toyopay.networkServices.ApiResult
import com.example.toyopay.networkServices.CommonApiService
import com.example.toyopay.networkServices.data.DetailsUserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AccountRepository @Inject constructor(private val api : CommonApiService) {

    suspend fun getProfileDetails(): Flow<ApiResult<List<DetailsUserResponse>>> = flow {
        emit(ApiResult.Loading)
        try {
            val profileData = api.getUserDetails()
            emit(ApiResult.Success(profileData.body()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage ?: "Unknown error"))
        }
    }
}