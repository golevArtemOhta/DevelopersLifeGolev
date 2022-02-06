package com.example.developerslifegolev.top

import retrofit2.http.GET

interface ApiRequestTop {

    @GET("/top/0?json=true")
    suspend fun getTopGif(): GifTopInfoItem

}