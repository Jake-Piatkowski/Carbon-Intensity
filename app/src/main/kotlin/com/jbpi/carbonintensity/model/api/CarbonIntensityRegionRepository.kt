package com.jbpi.carbonintensity.model.api

import com.jbpi.carbonintensity.network.CarbonIntensityRegionService
import com.jbpi.carbonintensity.utilities.Result
import com.jbpi.carbonintensity.utilities.error
import com.jbpi.carbonintensity.utilities.success

internal class CarbonIntensityRegionRepository(
    private val carbonIntensityRegionService: CarbonIntensityRegionService
) {
    suspend fun getRegions(): Result<Throwable, ApiRegionsList> =
        carbonIntensityRegionService.getRegions().fold(
            onFailure = {
                it.error()
            },
            onSuccess = {
                it.data[0].success()
            }
        )
}
