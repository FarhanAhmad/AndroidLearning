package com.black.androidlearning.ui.viewholders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.black.androidlearning.BR
import com.black.androidlearning.databinding.ItemCountryListBinding
import com.black.androidlearning.ui.model.CountryListItem

/**
 * Created by farhanahmad on 21/4/20.
 */
class CountryListItemViewHolder(private val viewBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: CountryListItem) {
        viewBinding.setVariable(BR.countryItem, item)
        (viewBinding as ItemCountryListBinding).countryItem = item
        viewBinding.executePendingBindings()
    }
}