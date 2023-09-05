package com.mordaski.challenge.feature.listing.presentation.model

import com.mordaski.challenge.common.model.Currency

sealed class ListingViewAction {
    object Retry : ListingViewAction()
    class onSelected(val from: Currency, val to: Currency) : ListingViewAction()
}