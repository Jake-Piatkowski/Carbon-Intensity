package com.jbpi.carbonintensity.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiRegionsResponse(
    @SerialName("data") val data: List<ApiRegionsList>
)

@Serializable
data class ApiRegionsList(
    @SerialName("from") val from: String,
    @SerialName("to") val to: String,
    @SerialName("regions") val regions: List<ApiRegion>
)

@Serializable
data class ApiRegion(
    @SerialName("regionid") val regionId: String,
    @SerialName("dnoregion") val dnoRegion: String,
    @SerialName("shortname") val shortName: String,
    @SerialName("intensity") val intensity: ApiIntensity,
    @SerialName("generationmix") val generationMix: List<ApiGenerationMix>
)

@Serializable
data class ApiIntensity(
    @SerialName("forecast") val forecast: Double,
    @SerialName("index") val index: String
)

@Serializable
data class ApiGenerationMix(
    @SerialName("fuel") val fuel: String,
    @SerialName("perc") val perc: Double
)
