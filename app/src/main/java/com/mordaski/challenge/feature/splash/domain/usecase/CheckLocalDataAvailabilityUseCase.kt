package com.mordaski.challenge.feature.splash.domain.usecase

import com.mordaski.challenge.common.base.BaseResult
import kotlinx.coroutines.flow.Flow

interface CheckLocalDataAvailabilityUseCase {
    suspend fun invoke(): Flow<BaseResult<Boolean, String>>
}