package com.jbpi.carbonintensity.model.domain

import java.time.ZonedDateTime

data class DomainRegionsList(
    val dateFrom: ZonedDateTime,
    val dateTo: ZonedDateTime,
    val regions: List<DomainRegion>
)

data class DomainRegion(
    val name: String,
    val intensity: DomainIntensity,
    val fuels: List<DomainFuel>
)

data class DomainIntensity(
    val forecast: Double,
    val index: String
)

data class DomainFuel(
    val name: String,
    val percentage: Double
)
