package com.black.androidlearning.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.black.androidlearning.databinding.FragmentCountryListBinding
import com.black.androidlearning.ui.adapters.CountryListAdapter
import com.black.androidlearning.viewmodel.CountryListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CountryListFragment : Fragment() {

    private val viewModel by viewModel<CountryListViewModel>()
    private var viewDataBinding: FragmentCountryListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentCountryListBinding.inflate(inflater, container, false)
        return viewDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding?.apply {
            rvCountryList.adapter = CountryListAdapter()
            rvCountryList.layoutManager = LinearLayoutManager(context)
            viewModel = this@CountryListFragment.viewModel
            executePendingBindings()
        }

        viewModel?.loadCountryList()
    }
}
