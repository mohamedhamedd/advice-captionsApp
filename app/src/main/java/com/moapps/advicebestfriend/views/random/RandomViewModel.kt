package com.moapps.advicebestfriend.views.random

import androidx.lifecycle.ViewModel
import com.moapps.advicebestfriend.data.repo.RandomRepo
import com.moapps.advicebestfriend.utilis.Coroutines
import com.moapps.advicebestfriend.utilis.NoInternetException
import java.lang.Exception

class RandomViewModel(var repo: RandomRepo) : ViewModel() {

    var iRandomAdvice: IRandomAdvice? = null

    fun getRandomAdvice() {

        Coroutines.main {
            try {
                val response = repo.getRandomAdvice()
                if (response.isSuccessful) {
                    iRandomAdvice?.onSuccess(response.body()?.slip?.advice)
                } else {
                    iRandomAdvice?.onError("error: Nothing Found")
                }
            } catch (ex: Exception) {
                iRandomAdvice?.onError(ex.message.toString())
            } catch (ex: NoInternetException) {
                iRandomAdvice?.onError(ex.message)
            }


        }

    }

}