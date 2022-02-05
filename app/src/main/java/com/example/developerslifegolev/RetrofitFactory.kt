package com.example.developerslifegolev

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    fun new() = Retrofit.Builder()
        .baseUrl("https://developerslife.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequest::class.java)
}