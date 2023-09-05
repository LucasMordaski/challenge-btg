package com.mordaski.challenge.feature.listing.data

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.model.Currency
import com.mordaski.challenge.feature.listing.data.datasource.GetAvailableExchangeRatesDataSource
import com.mordaski.challenge.feature.listing.domain.ListingRepository
import com.mordaski.challenge.feature.splash.data.datasource.CheckLocalDataAvailabilityDataSource
import com.mordaski.challenge.feature.splash.domain.SplashRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAvailableExchangeRatesImpl @Inject constructor(
    private val getAvailableExchangeRatesDataSource: GetAvailableExchangeRatesDataSource
) : ListingRepository {
    override suspend fun getAvailableExchangeRates(): Flow<BaseResult<List<Currency>, String>> =
        getAvailableExchangeRatesDataSource.checkLocalDataAvailability()
}