package com.mcoc.fsent

import android.app.Application
import com.androidnetworking.AndroidNetworking
import okhttp3.OkHttpClient
import com.facebook.stetho.okhttp3.StethoInterceptor

class FSentApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        AndroidNetworking.initialize(applicationContext)

        // Adding an Network Interceptor for Debugging purpose :
        val okHttpClient = OkHttpClient().newBuilder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
        AndroidNetworking.initialize(this.applicationContext, okHttpClient)
    }
}