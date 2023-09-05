package com.mordaski.challenge.feature.listing.data.datasource

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.factory.MockFactory
import com.mordaski.challenge.common.local.CacheDao
import com.mordaski.challenge.common.model.Currency
import com.mordaski.challenge.feature.listing.data.remote.GetAvailableExchangeRatesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAvailableExchangeRatesDataSourceImpl @Inject constructor(
    private val cacheDao: CacheDao,
    private val getAvailableExchangeRatesApi: GetAvailableExchangeRatesApi,
) : GetAvailableExchangeRatesDataSource {
    override suspend fun checkLocalDataAvailability(): Flow<BaseResult<List<Currency>, String>> {
        return flow {
            try {
//                getAvailableExchangeRatesApi.getRating().let {
//                    emit(BaseResult.Success(true))
//                } ?: emit(BaseResult.Success(false))
                emit(
                    BaseResult.Success(
                        MockFactory.makeList()
                    )
                )
            } catch (exception: Exception) {
                emit(BaseResult.Error(exception.message))
            }
        }.flowOn(Dispatchers.IO)
    }
}