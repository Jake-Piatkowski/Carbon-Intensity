package com.jbpi.carbonintensity.model.display

import com.jbpi.carbonintensity.model.domain.DomainFuel
import com.jbpi.carbonintensity.model.domain.DomainIntensity
import com.jbpi.carbonintensity.model.domain.DomainRegion
import com.jbpi.carbonintensity.model.domain.DomainRegionsList

internal class DomainToDisplayMapper(
    private val fuelPercentageFormatter: FuelPercentageFormatter
) {
    fun mapToDisplay(
        domainRegionsList: DomainRegionsList
    ): DisplayRegionsList =
        DisplayRegionsList(
            dateFrom = domainRegionsList.dateFrom,
            dateTo = domainRegionsList.dateTo,
            regions = domainRegionsList.regions.map { it.mapToDisplay() }
        )

    private fun DomainRegion.mapToDisplay(): DisplayRegion =
        DisplayRegion(
            name = name,
            intensity = intensity.mapToDisplay(),
            fuels = fuels.map { it.mapToDisplay() }
        )

    private fun DomainIntensity.mapToDisplay(): DisplayIntensity =
        DisplayIntensity(
            forecast = forecast.toString(),
            index = index
        )

    private fun DomainFuel.mapToDisplay(): DisplayFuel =
        DisplayFuel(
            name = name,
            percentage = fuelPercentageFormatter.format(percentage)
        )
}
