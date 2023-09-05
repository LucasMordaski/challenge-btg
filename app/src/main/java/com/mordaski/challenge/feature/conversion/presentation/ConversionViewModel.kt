package com.mordaski.challenge.feature.conversion.presentation

import androidx.lifecycle.viewModelScope
import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.base.BaseViewModel
import com.mordaski.challenge.feature.conversion.presentation.model.ConversionViewAction
import com.mordaski.challenge.feature.conversion.presentation.model.ConversionViewState
import com.mordaski.challenge.feature.splash.domain.usecase.CheckLocalDataAvailabilityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ConversionViewModel @Inject constructor() : BaseViewModel<ConversionViewState, ConversionViewAction>() {

    override val viewState = ConversionViewState()

    init {
        fetchLocalData()
    }

    override fun dispatchViewAction(viewAction: ConversionViewAction) {
        when (viewAction) {
            is ConversionViewAction.Retry -> fetchLocalData()
        }

    }

    private fun fetchLocalData() {
        viewModelScope.launch {
            handleDataResult(BaseResult.Success(true))
        }
    }

    private fun handleDataResult(result: BaseResult<Boolean, String>) {
        viewState.state.value = when (result) {
            is BaseResult.Success -> ConversionViewState.State.CurrencyConverterScreen(result.data)
            is BaseResult.Error -> ConversionViewState.State.Error(result.rawResponse)
        }
    }
}

