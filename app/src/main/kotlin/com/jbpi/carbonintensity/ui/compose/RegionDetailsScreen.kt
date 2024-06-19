package com.jbpi.carbonintensity.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbpi.carbonintensity.R
import com.jbpi.carbonintensity.model.display.DisplayRegion
import com.jbpi.carbonintensity.ui.theme.CarbonIntensityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RegionDetailsScreen(
    displayRegion: DisplayRegion
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = displayRegion.name // TODO change to proper name
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
    ) { paddingValues ->
        RegionDetailsScreenContent(
            modifier = Modifier.padding(paddingValues),
            displayRegion = displayRegion
        )
    }
}

@Composable
private fun RegionDetailsScreenContent(
    modifier: Modifier = Modifier,
    displayRegion: DisplayRegion
) {
    Column(
        modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 16.dp
        )
    ) {
        Text(stringResource(R.string.region_location, displayRegion.name))
        Text(stringResource(R.string.region_intensity, displayRegion.intensity.index))
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(displayRegion.fuels.size) {
                FuelGridItem(displayFuel = displayRegion.fuels[it])
            }
        }
    }
}

@Preview
@Composable
private fun Preview_RegionDetailsScreen() {
    CarbonIntensityTheme {
        Surface {
            RegionDetailsScreenContent(displayRegion = getDisplayRegion())
        }
    }
}
