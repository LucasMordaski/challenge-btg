package com.mordaski.challenge.feature.listing.di

import com.mordaski.challenge.common.local.CacheDao
import com.mordaski.challenge.di.DatabaseModule
import com.mordaski.challenge.di.NetworkModule
import com.mordaski.challenge.feature.listing.data.GetAvailableExchangeRatesImpl
import com.mordaski.challenge.feature.listing.data.datasource.GetAvailableExchangeRatesDataSource
import com.mordaski.challenge.feature.listing.data.datasource.GetAvailableExchangeRatesDataSourceImpl
import com.mordaski.challenge.feature.listing.data.remote.GetAvailableExchangeRatesApi
import com.mordaski.challenge.feature.listing.domain.ListingRepository
import com.mordaski.challenge.feature.listing.domain.usecase.GetAvailableExchangeRatesUseCase
import com.mordaski.challenge.feature.listing.domain.usecase.GetAvailableExchangeRatesUseCaseImpl
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
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class ListingModule {
    @Provides
    fun provideGetAvailableExchangeRatesUseCase(
        listingRepository: ListingRepository
    ): GetAvailableExchangeRatesUseCase {
        return GetAvailableExchangeRatesUseCaseImpl(listingRepository)
    }

    @Provides
    fun provideListingRepository(
        getAvailableExchangeRatesDataSource: GetAvailableExchangeRatesDataSource
    ): ListingRepository {
        return GetAvailableExchangeRatesImpl(getAvailableExchangeRatesDataSource)
    }

    @Provides
    fun provideGetAvailableExchangeRatesDataSource(
        cacheDao: CacheDao,
        getAvailableExchangeRatesApi: GetAvailableExchangeRatesApi
    ): GetAvailableExchangeRatesDataSource {
        return GetAvailableExchangeRatesDataSourceImpl(
            cacheDao,
            getAvailableExchangeRatesApi
        )
    }

    @Singleton
    @Provides
    fun provideGetAvailableExchangeRatesApi(retrofit: Retrofit): GetAvailableExchangeRatesApi {
        return retrofit.create(GetAvailableExchangeRatesApi::class.java)
    }

}