package com.jbpi.carbonintensity.model.domain

import com.jbpi.carbonintensity.model.api.ApiGenerationMix
import com.jbpi.carbonintensity.model.api.ApiIntensity
import com.jbpi.carbonintensity.model.api.ApiRegion
import com.jbpi.carbonintensity.model.api.ApiRegionsList
import java.time.ZonedDateTime
import kotlin.time.Duration

internal class ApiToDomainMapper {
    fun mapToDomain(
        apiRegionsList: ApiRegionsList
    ): DomainRegionsList =
        DomainRegionsList(
            dateFrom = ZonedDateTime.parse(apiRegionsList.from),
            dateTo = ZonedDateTime.parse(apiRegionsList.to),
            regions = apiRegionsList.regions.map { it.mapToDomain() }
        )

    private fun ApiRegion.mapToDomain(): DomainRegion =
        DomainRegion(
            name = shortName,
            intensity = intensity.mapToDomain(),
            fuels = generationMix.map { it.mapToDomain() }
        )

    private fun ApiIntensity.mapToDomain(): DomainIntensity =
        DomainIntensity(
            forecast = forecast,
            index = index
        )

    private fun ApiGenerationMix.mapToDomain(): DomainFuel =
        DomainFuel(
            name = fuel,
            percentage = perc
        )
}
