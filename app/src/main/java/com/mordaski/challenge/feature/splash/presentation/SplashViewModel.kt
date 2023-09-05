package com.mordaski.challenge.feature.splash.presentation

import androidx.lifecycle.viewModelScope
import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.base.BaseViewModel
import com.mordaski.challenge.feature.splash.domain.usecase.CheckLocalDataAvailabilityUseCase
import com.mordaski.challenge.feature.splash.presentation.model.SplashViewAction
import com.mordaski.challenge.feature.splash.presentation.model.SplashViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkLocalDataAvailabilityUseCase: CheckLocalDataAvailabilityUseCase,
) : BaseViewModel<SplashViewState, SplashViewAction>() {

    override val viewState = SplashViewState()

    init {
        fetchLocalData()
    }

    override fun dispatchViewAction(viewAction: SplashViewAction) {
        when (viewAction) {
            is SplashViewAction.Retry -> fetchLocalData()
        }

    }

    private fun fetchLocalData() {
        viewModelScope.launch {
            checkLocalDataAvailabilityUseCase.invoke()
                .catch {
                    viewState.state.value = SplashViewState.State.Error(it.message)
                }
                .collect {
                    handleDataResult(it)
                }
        }
    }

    private fun handleDataResult(result: BaseResult<Boolean, String>) {
        viewState.state.value = when (result) {
            is BaseResult.Success -> SplashViewState.State.Splash(result.data)
            is BaseResult.Error -> SplashViewState.State.Error(result.rawResponse)
        }
    }
}

