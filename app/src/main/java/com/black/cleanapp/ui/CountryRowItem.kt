package com.black.cleanapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.black.cleanapp.ui.theme.CleanAppTheme

@Composable
fun CountryRowItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    name: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = name,
            modifier = Modifier.size(100.dp, 100.dp)
        )

        Text(text = name, modifier = Modifier.padding(start = 16.dp))
    }
}

@Preview
@Composable
private fun CountryRowItemPreview() {
    CleanAppTheme {
        CountryRowItem(
            modifier = Modifier.fillMaxSize(),
            imageUrl = "",
            name = "Fiji",
        )
    }
}