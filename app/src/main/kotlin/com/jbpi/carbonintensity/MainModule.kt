package com.jbpi.carbonintensity

import android.content.res.Resources
import com.jbpi.carbonintensity.model.api.CarbonIntensityRegionRepository
import com.jbpi.carbonintensity.model.display.DomainToDisplayMapper
import com.jbpi.carbonintensity.model.display.FuelPercentageFormatter
import com.jbpi.carbonintensity.model.domain.ApiToDomainMapper
import com.jbpi.carbonintensity.network.CarbonIntensityRegionService
import io.ktor.client.HttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal fun getMainModule() = module {
    viewModel { provideMainViewModel(get(), get()) }
    factory { provideCarbonIntensityRegionRepository(get()) }
    factory { provideApiToDomainMapper() }
    factory { provideDomainToDisplayMapper(get()) }
    factory { provideFuelPercentageFormatter(androidContext().resources) }
    factory { provideGetRegionsListUseCase(get(), get()) }
}

private fun provideMainViewModel(
    getRegionsListUseCase: GetRegionsListUseCase,
    domainToDisplayMapper: DomainToDisplayMapper
) = MainViewModel(
    getRegionsListUseCase = getRegionsListUseCase,
    domainToDisplayMapper = domainToDisplayMapper
)

private fun provideCarbonIntensityRegionRepository(
    carbonIntensityRegionService: CarbonIntensityRegionService
) = CarbonIntensityRegionRepository(carbonIntensityRegionService)

private fun provideApiToDomainMapper() = ApiToDomainMapper()

private fun provideDomainToDisplayMapper(
    fuelPercentageFormatter: FuelPercentageFormatter
) = DomainToDisplayMapper(fuelPercentageFormatter)

private fun provideFuelPercentageFormatter(
    resources: Resources
) = FuelPercentageFormatter(resources)

private fun provideGetRegionsListUseCase(
    carbonIntensityRegionRepository: CarbonIntensityRegionRepository,
    apiToDomainMapper: ApiToDomainMapper
) =
    GetRegionsListUseCase(
        carbonIntensityRegionRepository = carbonIntensityRegionRepository,
        apiToDomainMapper = apiToDomainMapper
    )
