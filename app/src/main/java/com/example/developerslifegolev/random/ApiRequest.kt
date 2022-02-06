package com.example.developerslifegolev.random

import retrofit2.http.GET

interface ApiRequest {

    @GET("/random?json=true")
    suspend fun getGif(): GifInfoItem

}