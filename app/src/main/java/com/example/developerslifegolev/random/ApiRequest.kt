package com.example.developerslifegolev.random

import com.example.developerslifegolev.hot.GifHotInfoItem
import com.example.developerslifegolev.latest.GifLatestInfoItem
import com.example.developerslifegolev.top.GifTopInfoItem
import retrofit2.http.GET

interface ApiRequest {

    @GET("/random?json=true")
    suspend fun getGif(): GifInfoItem

    @GET("/hot/0?json=true")
    suspend fun getHotGif(): GifHotInfoItem

    @GET("/latest/0?json=true")
    suspend fun getLatestGif(): GifLatestInfoItem

    @GET("/top/0?json=true")
    suspend fun getTopGif(): GifTopInfoItem

}