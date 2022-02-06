package com.example.developerslifegolev.random

import com.example.developerslifegolev.random.ApiRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun new(apiRequest: Class<ApiRequest>) = Retrofit.Builder()
        .baseUrl("https://developerslife.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(apiRequest)
}