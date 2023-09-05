package com.mordaski.challenge.feature.splash.data

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.feature.splash.data.datasource.CheckLocalDataAvailabilityDataSource
import com.mordaski.challenge.feature.splash.domain.SplashRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(
    private val checkLocalDataAvailabilityDataSource: CheckLocalDataAvailabilityDataSource
) : SplashRepository {
    override suspend fun checkLocalDataAvailabilityUseCaseImpl(): Flow<BaseResult<Boolean, String>> =
        checkLocalDataAvailabilityDataSource.checkLocalDataAvailability()
}