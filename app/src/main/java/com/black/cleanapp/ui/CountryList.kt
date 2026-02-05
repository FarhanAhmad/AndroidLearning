package com.black.cleanapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.black.cleanapp.domain.model.CountryObj

@Composable
fun CountryList(
    modifier: Modifier = Modifier,
    countryList: List<CountryObj>,
    isLoading: Boolean,
) {
    if (isLoading) {
        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = modifier) {
            items(countryList) { countryItem ->
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    CountryRowItem(
                        imageUrl = countryItem.flag,
                        name = countryItem.name,
                    )
                    HorizontalDivider(
                        modifier = Modifier
                            .fillParentMaxWidth()
                    )
                }
            }
        }
    }
}