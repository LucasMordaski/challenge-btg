package com.mordaski.challenge.feature.splash.domain.usecase

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.feature.splash.domain.SplashRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckLocalDataAvailabilityUseCaseImpl @Inject constructor(
    private val splashRepository: SplashRepository
) : CheckLocalDataAvailabilityUseCase {
    override suspend fun invoke(): Flow<BaseResult<Boolean, String>> =
        splashRepository.checkLocalDataAvailabilityUseCaseImpl()
}