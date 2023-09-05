package com.mordaski.challenge.feature.splash.data.datasource

import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.local.CacheDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CheckLocalDataAvailabilityDataSourceImpl @Inject constructor(
    private val cacheDao: CacheDao
) : CheckLocalDataAvailabilityDataSource {
    override suspend fun checkLocalDataAvailability(): Flow<BaseResult<Boolean, String>> {
        return flow {
            try {
                cacheDao.getAllUsers()?.let {
                    emit(BaseResult.Success(true))
                } ?: emit(BaseResult.Success(false))
            } catch (exception: Exception) {
                emit(BaseResult.Error(exception.message))
            }
        }.flowOn(Dispatchers.IO)
    }
}