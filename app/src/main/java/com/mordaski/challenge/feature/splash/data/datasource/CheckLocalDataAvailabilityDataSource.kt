package com.mordaski.challenge.feature.splash.data.datasource

import com.mordaski.challenge.common.base.BaseResult
import kotlinx.coroutines.flow.Flow

interface CheckLocalDataAvailabilityDataSource {
    suspend fun checkLocalDataAvailability(): Flow<BaseResult<Boolean, String>>
}