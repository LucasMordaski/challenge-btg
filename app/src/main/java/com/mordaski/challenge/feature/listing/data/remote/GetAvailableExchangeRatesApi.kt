package com.mordaski.challenge.feature.listing.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface GetAvailableExchangeRatesApi {
    @GET("list")
    suspend fun getRating(): Response<String>

}