package com.jbpi.carbonintensity.network.di

import com.jbpi.carbonintensity.network.CarbonIntensityRegionService
import com.jbpi.carbonintensity.network.CarbonIntensityRegionServiceImpl
import com.jbpi.carbonintensity.network.provideHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun getNetworkModule() = module {
    single<HttpClient> { provideHttpClient() }
    factory<CarbonIntensityRegionService> { CarbonIntensityRegionServiceImpl(get()) }
}
