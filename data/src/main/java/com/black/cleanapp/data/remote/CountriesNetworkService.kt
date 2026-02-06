package com.black.cleanapp.data.remote

import com.black.cleanapp.data.model.CountryDTO
import retrofit2.http.GET

interface CountriesNetworkService {

    @GET("https://restcountries.com/v3.1/all?fields=name,flags")
    suspend fun getCountryList(): List<CountryDTO>
}