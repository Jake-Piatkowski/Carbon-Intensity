package com.jbpi.carbonintensity.model.display

import java.time.ZonedDateTime

data class DisplayRegionsList(
    val dateFrom: ZonedDateTime,
    val dateTo: ZonedDateTime,
    val regions: List<DisplayRegion>
)

data class DisplayRegion(
    val name: String,
    val intensity: DisplayIntensity,
    val fuels: List<DisplayFuel>
)

data class DisplayIntensity(
    val forecast: String,
    val index: String
)

data class DisplayFuel(
    val name: String,
    val percentage: String
)
