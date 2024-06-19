package com.jbpi.carbonintensity.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbpi.carbonintensity.MainViewModel
import com.jbpi.carbonintensity.R
import com.jbpi.carbonintensity.model.display.DisplayRegionsList
import com.jbpi.carbonintensity.model.display.ScreenState
import com.jbpi.carbonintensity.ui.theme.CarbonIntensityTheme
import org.koin.androidx.compose.koinViewModel
import java.time.ZonedDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RegionsScreen(
    mainViewModel: MainViewModel = koinViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = stringResource(R.string.regions_screen_title)
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
        val screenState = mainViewModel.screenStateFlow.collectAsState()

        RegionsScreenContent(
            modifier = Modifier.padding(paddingValues),
            screenState = screenState.value
        )
    }
}

@Composable
private fun RegionsScreenContent(
    modifier: Modifier = Modifier,
    screenState: ScreenState
) {
    when (screenState) {
        is ScreenState.Error -> {}
        is ScreenState.Loading -> {}
        is ScreenState.Success -> {
            Column(
                modifier = modifier
            ) {

                LazyColumn {
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }

                    screenState.displayRegionsList.regions.forEachIndexed { index, it ->
                        item {
                            RegionListItem(displayRegion = it)

                            if (index != screenState.displayRegionsList.regions.lastIndex) {
                                HorizontalDivider(
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    thickness = 2.dp
                                )
                            }
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_RegionsScreen() {
    CarbonIntensityTheme {
        Surface {
            RegionsScreenContent(
                screenState = ScreenState.Success(
                    displayRegionsList = DisplayRegionsList(
                        dateFrom = ZonedDateTime.now(),
                        dateTo = ZonedDateTime.now(),
                        regions = listOf(
                            getDisplayRegion(),
                            getDisplayRegion(),
                            getDisplayRegion()
                        )
                    )
                )
            )
        }
    }
}
