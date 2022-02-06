package com.example.developerslifegolev.top

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactoryTop {

    fun new() = Retrofit.Builder()
        .baseUrl("https://developerslife.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequestTop::class.java)
}