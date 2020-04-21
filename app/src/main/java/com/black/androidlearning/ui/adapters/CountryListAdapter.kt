package com.black.androidlearning.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.black.androidlearning.databinding.ItemCountryListBinding
import com.black.androidlearning.ui.model.CountryListItem
import com.black.androidlearning.ui.viewholders.CountryListItemViewHolder

/**
 * Created by farhanahmad on 21/4/20.
 */
class CountryListAdapter : ListAdapter<CountryListItem, CountryListItemViewHolder>(DIFF_CALLBACK) {
    companion object {
        val DIFF_CALLBACK =
                object : DiffUtil.ItemCallback<CountryListItem>() {
                    override fun areItemsTheSame(oldItem: CountryListItem, newItem: CountryListItem): Boolean {
                        return oldItem == newItem
                    }

                    override fun areContentsTheSame(oldItem: CountryListItem, newItem: CountryListItem): Boolean {
                        return oldItem == newItem
                    }

                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListItemViewHolder {
        val binding = ItemCountryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}