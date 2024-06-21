package com.jbpi.carbonintensity.network.di

import com.jbpi.carbonintensity.network.CarbonIntensityRegionService
import com.jbpi.carbonintensity.network.CarbonIntensityRegionServiceImpl
import org.koin.dsl.module

fun getCarbonIntensityRegionModule() = module {
    factory<CarbonIntensityRegionService> { CarbonIntensityRegionServiceImpl(get()) }
}