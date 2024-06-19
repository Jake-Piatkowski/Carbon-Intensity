package com.jbpi.carbonintensity.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbpi.carbonintensity.R
import com.jbpi.carbonintensity.model.display.DisplayFuel
import com.jbpi.carbonintensity.model.display.DisplayRegion
import com.jbpi.carbonintensity.ui.theme.CarbonIntensityTheme

@Composable
internal fun RegionListItem(
    displayRegion: DisplayRegion
) {
    Column(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Text(displayRegion.name)
        Spacer(modifier = Modifier.height(4.dp))
        Text(stringResource(R.string.region_intensity, displayRegion.intensity.index))
    }
}

@Preview
@Composable
private fun Preview_Region() {
    CarbonIntensityTheme {
        Surface {
            RegionListItem(
                displayRegion = getDisplayRegion()
            )
        }
    }
}

@Composable
internal fun FuelGridItem(
    displayFuel: DisplayFuel
) {
    Column(
        modifier = Modifier.size(size = 72.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(displayFuel.name)
        Spacer(modifier = Modifier.height(4.dp))
        Text(displayFuel.percentage)
    }
}

@Preview
@Composable
private fun Preview_Fuel() {
    CarbonIntensityTheme {
        Surface {
            FuelGridItem(
                displayFuel = displayFuelNuclear
            )
        }
    }
}
