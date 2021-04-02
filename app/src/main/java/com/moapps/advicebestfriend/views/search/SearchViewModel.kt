package com.moapps.advicebestfriend.views.search

import androidx.lifecycle.ViewModel
import com.moapps.advicebestfriend.data.repo.SearchRepo
import com.moapps.advicebestfriend.utilis.Coroutines
import com.moapps.advicebestfriend.utilis.NoInternetException
import java.lang.Exception

class SearchViewModel(var repo: SearchRepo) : ViewModel() {

    var iSearchAdvice: ISearchAdvice? = null

    fun getSearchAdvice(query: String) {

        iSearchAdvice?.onStarted()

        Coroutines.main {
            try {
                val response = repo.getSearchAdvice(query)
                if (response.isSuccessful) {
                    iSearchAdvice?.onSuccess(response.body()?.slips!!)
                } else {
                    iSearchAdvice?.onError("error: Nothing Found")
                }
            } catch (ex: Exception) {
                iSearchAdvice?.onError(ex.message.toString())
            } catch (ex: NoInternetException) {
                iSearchAdvice?.onError(ex.message)
            }

        }

    }

}