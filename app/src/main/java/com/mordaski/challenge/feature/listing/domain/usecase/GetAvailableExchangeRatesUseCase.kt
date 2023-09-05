package com.mordaski.challenge.feature.listing.domain.usecase

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.model.Currency
import kotlinx.coroutines.flow.Flow

interface GetAvailableExchangeRatesUseCase {
    suspend fun invoke(): Flow<BaseResult<List<Currency>, String>>
}