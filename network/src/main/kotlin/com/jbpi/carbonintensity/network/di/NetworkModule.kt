package com.jbpi.carbonintensity.network.di

import io.ktor.client.HttpClient
import org.koin.dsl.module

fun getNetworkModule() = module {
    single<HttpClient> { com.jbpi.carbonintensity.network.provideHttpClient() }
}
