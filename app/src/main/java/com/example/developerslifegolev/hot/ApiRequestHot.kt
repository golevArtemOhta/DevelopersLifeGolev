package com.example.developerslifegolev.hot

import retrofit2.http.GET

interface ApiRequestHot {

    @GET("/hot/0?json=true")
    suspend fun getHotGif(): GifHotInfoItem

}