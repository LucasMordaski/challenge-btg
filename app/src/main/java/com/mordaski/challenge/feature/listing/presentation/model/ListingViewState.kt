package com.mordaski.challenge.feature.listing.presentation.model

import com.mordaski.challenge.common.model.Currency
import kotlinx.coroutines.flow.MutableStateFlow

class ListingViewState {

    val state = MutableStateFlow<State>(State.Loading)

    sealed class State {
        object Loading : State()
        class Splash(val list: List<Currency>) : State()
        class Error(val message: String?) : State()
    }
}