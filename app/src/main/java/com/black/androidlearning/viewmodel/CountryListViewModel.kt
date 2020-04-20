package com.black.androidlearning.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.black.androidlearning.ui.model.CountryListItem

/**
 * Created by farhanahmad on 20/4/20.
 */
class CountryListViewModel : ViewModel() {

    val countryListItems = ObservableArrayList<CountryListItem>()

    init {
        loadCountryList()
    }

    private fun loadCountryList() {
        // add items here
        // for databinding scope, I am loading hard coded couple of values

        countryListItems.add(CountryListItem("Afghanistan","Kabul",0L,"https://restcountries.eu/data/afg.svg"))
        countryListItems.add(CountryListItem("France","Paris",0L,"https://restcountries.eu/data/fra.svg"))
        countryListItems.add(CountryListItem("Germany","Berlin",0L,"https://restcountries.eu/data/deu.svg"))
        countryListItems.add(CountryListItem("India","New Delhi",0L,"https://restcountries.eu/data/ind.svg"))
        countryListItems.add(CountryListItem("Pakistan","Islamabad",0L,"https://restcountries.eu/data/pak.svg"))
        countryListItems.add(CountryListItem("United States of America","Washington, D.C.",0L,"https://restcountries.eu/data/usa.svg"))
        countryListItems.add(CountryListItem("Zimbabwe","Harare",0L,"https://restcountries.eu/data/zwe.svg"))


    }

}