package com.example.developerslifegolev

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun new(apiRequest: Class<ApiRequest>) = Retrofit.Builder()
        .baseUrl("https://developerslife.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(apiRequest)
}