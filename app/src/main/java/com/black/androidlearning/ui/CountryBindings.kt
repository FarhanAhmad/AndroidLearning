package com.black.androidlearning.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.black.androidlearning.R
import com.black.androidlearning.ui.adapters.CountryListAdapter
import com.black.androidlearning.ui.model.CountryListItem
import com.bumptech.glide.Glide

/**
 * Created by farhanahmad on 21/4/20.
 */

@BindingAdapter("app:countryItems")
fun setCountryItems(rv: RecyclerView, list: List<CountryListItem>?) {
    (rv.adapter as CountryListAdapter).submitList(list)
}

@BindingAdapter("app:imageUrl")
fun setCountryItemFlag(iv: ImageView, url: String?) {
    Glide.with(iv.context).load(url).error(R.mipmap.ic_launcher).into(iv)
}