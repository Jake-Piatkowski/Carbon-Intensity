package com.jbpi.carbonintensity.model.display

sealed interface ScreenState {

    data object Loading : ScreenState

    data class Error(val error : String) : ScreenState

    data class Success(val displayRegionsList: DisplayRegionsList) : ScreenState
}
