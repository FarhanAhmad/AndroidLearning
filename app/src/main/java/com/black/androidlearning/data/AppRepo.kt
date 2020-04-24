package com.black.androidlearning.data

import com.black.androidlearning.data.remote.INetworkSource
import com.black.androidlearning.model.CountryDTO

/**
 * AppRepo is the class, our usecases or viewmodel will be calling.
 *
 * Created by farhanahmad on 24/4/20.
 */
class AppRepo(private val networkSource: INetworkSource) {

    suspend fun getCountryList(): List<CountryDTO> {
        /**
         * Can add further functionality here, like get data from localSource in future.
         */
        return networkSource.getCountryList()
    }

}