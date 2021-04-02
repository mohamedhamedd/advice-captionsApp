package com.moapps.advicebestfriend.data.repo

import com.moapps.advicebestfriend.data.network.RetrofitClient
import com.moapps.advicebestfriend.data.network.api.ApiEndPoints
import com.moapps.advicebestfriend.pojo.SearchAdvice
import retrofit2.Response

class SearchRepo(var retrofitClient: RetrofitClient) {

    suspend fun getSearchAdvice(query:String) : Response<SearchAdvice>{
        return retrofitClient.getAPI(ApiEndPoints::class.java).getSearchAdvice(query)
    }

}