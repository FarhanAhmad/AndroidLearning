package com.black.androidlearning.data.remote

import com.black.androidlearning.model.CountryDTO

/**
 * Created by farhanahmad on 24/4/20.
 */
interface INetworkSource {

    suspend fun getCountryList():List<CountryDTO>?
}