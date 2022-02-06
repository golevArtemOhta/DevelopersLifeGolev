package com.example.developerslifegolev.hot

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactoryHot {

    fun new() = Retrofit.Builder()
        .baseUrl("https://developerslife.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequestHot::class.java)
}