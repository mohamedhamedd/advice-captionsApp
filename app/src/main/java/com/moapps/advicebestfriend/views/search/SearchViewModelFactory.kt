package com.moapps.advicebestfriend.views.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moapps.advicebestfriend.data.repo.SearchRepo

@Suppress("UNCHECKED_CAST")
class SearchViewModelFactory (private val repo: SearchRepo
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repo) as T
    }

}