package com.example.trudvsemapi

import com.example.trudvsemapi.retrofit.trudvsemApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: trudvsemApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://opendata.trudvsem.ru/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(trudvsemApiService::class.java)
    }
}