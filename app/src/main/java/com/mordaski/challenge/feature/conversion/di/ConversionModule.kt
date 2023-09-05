package com.mordaski.challenge.feature.conversion.di

import com.mordaski.challenge.di.DatabaseModule
import com.mordaski.challenge.di.NetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class ConversionModule {

}