package com.mordaski.challenge.feature.splash.domain

import com.mordaski.challenge.common.base.BaseResult
import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    suspend fun checkLocalDataAvailabilityUseCaseImpl(): Flow<BaseResult<Boolean, String>>
}