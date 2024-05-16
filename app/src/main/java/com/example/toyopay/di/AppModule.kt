package com.example.toyopay.di

import android.content.Context
import com.example.toyopay.networkServices.CommonApiService
import com.example.toyopay.networkServices.OkHttpClientHelper
import com.example.toyopay.util.others.Constants.BASE_URL
import com.example.toyopay.util.sharedPref.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesTayoPayApi(sharedPref: SharedPref): CommonApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(OkHttpClientHelper(sharedPref).getOkHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CommonApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPref(@ApplicationContext context: Context): SharedPref= SharedPref(context)



}