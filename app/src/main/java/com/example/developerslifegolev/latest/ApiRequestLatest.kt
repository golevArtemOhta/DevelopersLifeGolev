package com.example.developerslifegolev.latest

import com.example.developerslifegolev.random.GifInfoItem
import retrofit2.http.GET

interface ApiRequestLatest {

    @GET("/latest/0?json=true")
    suspend fun getLatestGif(): GifLatestInfoItem

}