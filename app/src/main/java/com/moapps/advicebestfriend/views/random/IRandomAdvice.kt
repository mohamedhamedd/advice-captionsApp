package com.moapps.advicebestfriend.views.random

interface IRandomAdvice {

    fun onSuccess(advice: String?)
    fun onError(message: String?)

}