package com.black.cleanapp.data.model

import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("name")
    val name: CountryName? = null,
    @SerializedName("flags")
    val flag: CountryFlag? = null,
)

data class CountryName(
    @SerializedName("official")
    val official: String?
)

data class CountryFlag(
    @SerializedName("png")
    val pngUrl: String?
)