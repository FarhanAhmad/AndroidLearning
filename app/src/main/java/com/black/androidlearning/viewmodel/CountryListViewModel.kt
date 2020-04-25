package com.black.androidlearning.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.black.androidlearning.data.AppRepo
import com.black.androidlearning.data.usecases.GetCountryListUseCase
import com.black.androidlearning.ui.model.CountryListItem
import com.black.androidlearning.utils.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by farhanahmad on 20/4/20.
 */
class CountryListViewModel(private val appRepo: AppRepo) : ViewModel() {

    val TAG = "CountryListVM"
    val countryListItems = ObservableArrayList<CountryListItem>()

    init {
        Logger.e(TAG,"init")
        loadCountryList()
    }

    private fun loadCountryList() {

        /**
         * Launch a coroutine to execute the use case.
         */
        viewModelScope.launch(Dispatchers.IO) {

            val countryListUseCase = GetCountryListUseCase(appRepo)
            val list = countryListUseCase.execute()

            Logger.i(TAG, "Received country list:${list.size}")
            launch(Dispatchers.Main) {
                countryListItems.addAll(list)
            }

        }

    }

}