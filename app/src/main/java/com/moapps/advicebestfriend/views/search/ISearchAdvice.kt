package com.moapps.advicebestfriend.views.search

import com.moapps.advicebestfriend.pojo.SlipX

interface ISearchAdvice {

    fun onStarted()
    fun onSuccess(list: List<SlipX>)
    fun onError(message: String?)

}