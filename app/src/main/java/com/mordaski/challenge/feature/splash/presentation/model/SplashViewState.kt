package com.mordaski.challenge.feature.splash.presentation.model

import kotlinx.coroutines.flow.MutableStateFlow

class SplashViewState {

    val state = MutableStateFlow<State>(State.Loading)

    sealed class State {
        object Loading : State()
        class Splash(val conected: Boolean) : State()
        class Error(val message: String?) : State()
    }
}