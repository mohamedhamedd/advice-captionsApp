package com.moapps.advicebestfriend.data.repo

import com.moapps.advicebestfriend.data.network.RetrofitClient
import com.moapps.advicebestfriend.data.network.api.ApiEndPoints
import com.moapps.advicebestfriend.pojo.Advice
import retrofit2.Response

class RandomRepo(var retrofitClient: RetrofitClient) {

    suspend fun getRandomAdvice(): Response<Advice> {
        return retrofitClient.getAPI(ApiEndPoints::class.java).getRandomAdvice()
    }

}