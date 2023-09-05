package com.mordaski.challenge.feature.conversion.presentation.model

import kotlinx.coroutines.flow.MutableStateFlow

class ConversionViewState {

    val state = MutableStateFlow<State>(State.Loading)


    sealed class State {
        object Loading : State()
        class CurrencyConverterScreen(val conected: Boolean) : State()
        class Error(val message: String?) : State()
    }
}