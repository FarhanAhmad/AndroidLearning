package com.black.androidlearning.di

import com.black.androidlearning.data.AppRepo
import com.black.androidlearning.data.remote.INetworkSource
import com.black.androidlearning.data.remote.NetworkDataSource
import com.black.androidlearning.viewmodel.CountryListViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Created by farhanahmad on 25/4/20.
 */

private val utilModule = module {
    single { OkHttpClient() }
}
private val dataModule = module {
    single<INetworkSource> { NetworkDataSource(get()) }
    single { AppRepo(get()) }
}

private val countriesModule = module {
    single { CountryListViewModel(get()) }
}

val modules = listOf(dataModule, utilModule, countriesModule)