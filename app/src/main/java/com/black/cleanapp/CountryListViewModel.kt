package com.black.cleanapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.black.cleanapp.domain.model.CountryObj
import com.black.cleanapp.domain.repository.AppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val appRepo: AppRepo,
) : ViewModel() {

    private val _countryListStateFlow = MutableStateFlow(CountryListState())
    val countryListStateFlow = _countryListStateFlow.asStateFlow()

    init {
        _countryListStateFlow.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            val list = appRepo.getCountryList()

            _countryListStateFlow.update {
                it.copy(
                    countryList = list,
                    isLoading = false,
                )
            }
        }
    }
}

data class CountryListState(
    val countryList: List<CountryObj> = emptyList(),
    val isLoading: Boolean = false,
)