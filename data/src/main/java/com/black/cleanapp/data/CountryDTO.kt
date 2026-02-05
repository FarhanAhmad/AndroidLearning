package com.black.cleanapp.data;

import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("name")
    val name: CountryName?,
    @SerializedName("flags")
    val flag: CountryFlag?,
)

data class CountryName(
    @SerializedName("official")
    val official: String?
)

data class CountryFlag(
    @SerializedName("png")
    val pngUrl: String?
)