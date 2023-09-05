package com.mordaski.challenge.feature.listing.data.datasource

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.model.Currency
import kotlinx.coroutines.flow.Flow

interface GetAvailableExchangeRatesDataSource {
    suspend fun checkLocalDataAvailability(): Flow<BaseResult<List<Currency>, String>>
}