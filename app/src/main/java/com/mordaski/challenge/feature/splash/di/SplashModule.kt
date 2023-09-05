package com.mordaski.challenge.feature.splash.di

import com.mordaski.challenge.common.local.CacheDao
import com.mordaski.challenge.di.DatabaseModule
import com.mordaski.challenge.di.NetworkModule
import com.mordaski.challenge.feature.splash.data.SplashRepositoryImpl
import com.mordaski.challenge.feature.splash.data.datasource.CheckLocalDataAvailabilityDataSource
import com.mordaski.challenge.feature.splash.data.datasource.CheckLocalDataAvailabilityDataSourceImpl
import com.mordaski.challenge.feature.splash.domain.SplashRepository
import com.mordaski.challenge.feature.splash.domain.usecase.CheckLocalDataAvailabilityUseCase
import com.mordaski.challenge.feature.splash.domain.usecase.CheckLocalDataAvailabilityUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class SplashModule {

    @Provides
    fun provideCheckLocalDataAvailabilityUseCase(
        splashRepository: SplashRepository
    ): CheckLocalDataAvailabilityUseCase {
        return CheckLocalDataAvailabilityUseCaseImpl(splashRepository)
    }

    @Provides
    fun provideSplashRepository(
        checkLocalDataAvailabilityDataSource: CheckLocalDataAvailabilityDataSource
    ): SplashRepository {
        return SplashRepositoryImpl(checkLocalDataAvailabilityDataSource)
    }

    @Provides
    fun provideCheckLocalDataAvailabilityDataSource(
        cacheDao: CacheDao
    ): CheckLocalDataAvailabilityDataSource {
        return CheckLocalDataAvailabilityDataSourceImpl(cacheDao)
    }

}