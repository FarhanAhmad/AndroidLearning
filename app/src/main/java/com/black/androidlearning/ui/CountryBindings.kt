package com.black.androidlearning.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.black.androidlearning.ui.model.CountryListItem

/**
 * Created by farhanahmad on 21/4/20.
 */

@BindingAdapter("app:countryItems")
fun setCountryItems(rv: RecyclerView, list: List<CountryListItem>?) {

}

@BindingAdapter("app:imageUrl")
fun setCountryItemFlag(iv: ImageView, url: String?) {

}