package com.black.androidlearning.data.usecases

import com.black.androidlearning.data.AppRepo
import com.black.androidlearning.ui.model.CountryListItem

/**
 * Created by farhanahmad on 25/4/20.
 */
class GetCountryListUseCase(val appRepo: AppRepo) {
    /**
     * Keeping it simple for now.
     * In future, will be extended from a baseUseCase
     */

    /**
     * Get the data from remote source, transfer into object need to show on UI
     */
    suspend fun execute(): List<CountryListItem>? {

        return appRepo.getCountryList()?.map {
            CountryListItem(it.name, it.capital, it.population, it.flag)
        }
    }
}