package com.example.developerslifegolev.latest

import com.example.developerslifegolev.random.ApiRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactoryLatest {

    fun new() = Retrofit.Builder()
        .baseUrl("https://developerslife.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequestLatest::class.java)
}