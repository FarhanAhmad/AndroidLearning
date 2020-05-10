package com.black.androidlearning.data.remote

import com.black.androidlearning.model.CountryDTO
import com.black.androidlearning.utils.Urls
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Type

/**
 * Created by farhanahmad on 24/4/20.
 */
class NetworkDataSource(private val httpClient: OkHttpClient):INetworkSource {

    override suspend fun getCountryList(): List<CountryDTO>? {

        val request = Request.Builder()
                .url(Urls.countryListUrl)
                .build()

        val response = httpClient.newCall(request).execute()

        if(response.isSuccessful){
            val responseStr = response.body?.string()

            val type = object : TypeToken<ArrayList<CountryDTO>>(){}.type
            return Gson().fromJson(responseStr,type)
        }

        return arrayListOf()
    }
}