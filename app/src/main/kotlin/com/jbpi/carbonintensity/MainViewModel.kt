package com.jbpi.carbonintensity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbpi.carbonintensity.model.display.DomainToDisplayMapper
import com.jbpi.carbonintensity.model.display.ScreenState
import com.jbpi.carbonintensity.utilities.fold
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class MainViewModel(
    getRegionsListUseCase: GetRegionsListUseCase,
    private val domainToDisplayMapper: DomainToDisplayMapper,

) : ViewModel() {

    private val _screenStateFlow: Flow<ScreenState> = getRegionsListUseCase()
        .map { result ->
            result.fold(
                ifError = {
                    ScreenState.Error(it.message ?: "Unknown error")
                },
                ifSuccess = {
                    ScreenState.Success(domainToDisplayMapper.mapToDisplay(it))
                }
            )
        }
        .flowOn(Dispatchers.IO)
    val screenStateFlow =
        _screenStateFlow.stateIn(viewModelScope, SharingStarted.Eagerly, ScreenState.Loading)

    fun dispatchUiEvent(uiEvent: UiEvent) {

    }
}
