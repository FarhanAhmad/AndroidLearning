package com.black.androidlearning

import android.app.Application
import com.black.androidlearning.di.modules
import org.koin.android.ext.android.startKoin

/**
 * Created by farhanahmad on 25/4/20.
 */
class CountriesApp : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin(this, modules)
    }
}