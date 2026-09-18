package com.example.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (NetworkConfig.ENABLE_LOGGING) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(NetworkConfig.CONNECT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .readTimeout(NetworkConfig.READ_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .writeTimeout(NetworkConfig.WRITE_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
