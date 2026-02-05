package com.black.cleanapp.domain.repository

import com.black.cleanapp.domain.model.CountryObj

interface AppRepo {
    suspend fun getCountryList(): List<CountryObj>
}