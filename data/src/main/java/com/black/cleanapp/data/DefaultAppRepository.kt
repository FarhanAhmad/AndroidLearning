package com.black.cleanapp.data

import com.black.cleanapp.domain.model.CountryObj
import com.black.cleanapp.domain.repository.AppRepo
import javax.inject.Inject

class DefaultAppRepository @Inject constructor(
    val countriesNetworkService: CountriesNetworkService,
) : AppRepo {
    override suspend fun getCountryList(): List<CountryObj> {
        return countriesNetworkService.getCountryList()
            .filter {
                it.name?.official?.isNotBlank() == true
                        && it.flag != null
            }
            .map {
                CountryObj(
                    name = it.name?.official ?: "",
                    flag = it.flag?.pngUrl ?: "",
                )
            }
    }
}