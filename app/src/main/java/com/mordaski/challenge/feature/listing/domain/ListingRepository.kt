package com.mordaski.challenge.feature.listing.domain

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.model.Currency
import kotlinx.coroutines.flow.Flow

interface ListingRepository {
    suspend fun getAvailableExchangeRates(): Flow<BaseResult<List<Currency>, String>>
}