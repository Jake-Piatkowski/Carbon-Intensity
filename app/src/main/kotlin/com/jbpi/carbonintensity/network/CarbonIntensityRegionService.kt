package com.jbpi.carbonintensity.network

import com.jbpi.carbonintensity.model.api.ApiRegionsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface CarbonIntensityRegionService {
    suspend fun getRegions(): Result<ApiRegionsResponse>
}

class CarbonIntensityRegionServiceImpl(
    private val httpClient: HttpClient
) : CarbonIntensityRegionService {

    override suspend fun getRegions(): Result<ApiRegionsResponse> =
        runCatching {
            httpClient.get("https://api.carbonintensity.org.uk/regional").body()
        }
}
