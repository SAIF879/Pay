package com.example.toyopay.networkServices

import com.example.toyopay.networkServices.data.DetailsUserResponse
import com.example.toyopay.networkServices.data.LoginData
import com.example.toyopay.networkServices.data.LoginRequestBody
import com.example.toyopay.networkServices.data.LoginUserResponse
import com.example.toyopay.networkServices.data.RegisterRequestBody
import com.example.toyopay.networkServices.data.RegisterUserData
import com.example.toyopay.networkServices.data.RegisterUserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface CommonApiService {


    @POST("/user/register")
    suspend fun registerUser(@Body requestBody: RegisterRequestBody): Response<RegisterUserResponse>

    @POST("/auth/login")
    suspend fun loginUser(@Body requestBody : LoginRequestBody) : Response<LoginUserResponse>

    @GET("/user/detail")
    suspend fun getUserDetails(): Response<List<DetailsUserResponse>>


}
