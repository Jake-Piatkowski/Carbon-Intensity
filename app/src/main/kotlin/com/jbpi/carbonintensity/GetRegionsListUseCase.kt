package com.jbpi.carbonintensity

import com.jbpi.carbonintensity.model.api.CarbonIntensityRegionRepository
import com.jbpi.carbonintensity.model.domain.ApiToDomainMapper
import com.jbpi.carbonintensity.model.domain.DomainRegionsList
import com.jbpi.carbonintensity.utilities.Result
import com.jbpi.carbonintensity.utilities.error
import com.jbpi.carbonintensity.utilities.fold
import com.jbpi.carbonintensity.utilities.success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class GetRegionsListUseCase(
    private val carbonIntensityRegionRepository: CarbonIntensityRegionRepository,
    private val apiToDomainMapper: ApiToDomainMapper
) {
    operator fun invoke(): Flow<Result<Throwable, DomainRegionsList>> = flow {
        val getRegionsResponse = carbonIntensityRegionRepository.getRegions()

        getRegionsResponse.fold(
            ifError = {
                emit(it.error())
            },
            ifSuccess = { apiRegionsList ->
                emit(apiToDomainMapper.mapToDomain(apiRegionsList).success())
            }
        )
    }.flowOn(Dispatchers.IO)
}
