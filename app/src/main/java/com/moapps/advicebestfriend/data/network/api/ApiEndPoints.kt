package com.moapps.advicebestfriend.data.network.api

import com.moapps.advicebestfriend.pojo.Advice
import com.moapps.advicebestfriend.pojo.SearchAdvice
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndPoints {

    @GET("advice")
    suspend fun getRandomAdvice(): Response<Advice>

    @GET("advice/search/{query}")
    suspend fun getSearchAdvice(@Path("query") query:String): Response<SearchAdvice>

}