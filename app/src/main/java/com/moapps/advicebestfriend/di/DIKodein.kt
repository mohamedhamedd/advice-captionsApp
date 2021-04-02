package com.moapps.advicebestfriend.di

import android.app.Application
import com.moapps.advicebestfriend.data.network.RetrofitClient
import com.moapps.advicebestfriend.data.network.api.NetworkConnectionInterceptor
import com.moapps.advicebestfriend.data.repo.RandomRepo
import com.moapps.advicebestfriend.data.repo.SearchRepo
import com.moapps.advicebestfriend.views.random.RandomViewModelFactory
import com.moapps.advicebestfriend.views.search.SearchViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DIKodein : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {

        import(androidXModule(this@DIKodein))

        //NetworkConnection
        bind() from singleton { NetworkConnectionInterceptor(instance()) }

        //API
        bind() from singleton { RetrofitClient(instance()) }

        //Repositories
        bind() from singleton { RandomRepo(instance()) }
        bind() from singleton { SearchRepo(instance()) }

        //ViewModel Factory
        bind() from provider { RandomViewModelFactory(instance()) }
        bind() from provider { SearchViewModelFactory(instance()) }


    }
}