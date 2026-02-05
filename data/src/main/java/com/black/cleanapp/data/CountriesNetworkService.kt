package com.black.cleanapp.data

import retrofit2.http.GET

interface CountriesNetworkService {

    @GET("https://restcountries.com/v3.1/all?fields=name,flags")
    suspend fun getCountryList(): List<CountryDTO>
}