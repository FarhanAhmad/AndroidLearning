package com.black.androidlearning.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.black.androidlearning.data.AppRepo
import com.black.androidlearning.ui.model.CountryListItem

/**
 * Created by farhanahmad on 20/4/20.
 */
class CountryListViewModel(private val appRepo: AppRepo) : ViewModel() {

    val countryListItems = ObservableArrayList<CountryListItem>()

    fun loadCountryList() {
        // add items here
        // for databinding scope, I am loading hard coded couple of values


    }

}