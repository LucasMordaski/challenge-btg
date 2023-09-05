package com.mordaski.challenge.feature.listing.domain.usecase

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.model.Currency
import com.mordaski.challenge.feature.listing.domain.ListingRepository
import com.mordaski.challenge.feature.splash.domain.SplashRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAvailableExchangeRatesUseCaseImpl @Inject constructor(
    private val listingRepository: ListingRepository
) : GetAvailableExchangeRatesUseCase {
    override suspend fun invoke(): Flow<BaseResult<List<Currency>, String>> =
        listingRepository.getAvailableExchangeRates()
}