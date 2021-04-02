package com.moapps.advicebestfriend.views.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moapps.advicebestfriend.data.repo.RandomRepo

@Suppress("UNCHECKED_CAST")
class RandomViewModelFactory (private val repo: RandomRepo
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RandomViewModel(repo) as T
    }

}