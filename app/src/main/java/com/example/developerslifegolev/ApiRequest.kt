package com.example.developerslifegolev

import retrofit2.http.GET

interface ApiRequest {

    @GET("/random?json=true")
    suspend fun getGif(): GifInfoItem

}