package com.example.toyopay

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ToyoPayApp : Application() {
    companion object{
        @JvmStatic
        var instance : ToyoPayApp? = null
        @JvmStatic
        fun getContext() : Context? {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance= this
    }
}
