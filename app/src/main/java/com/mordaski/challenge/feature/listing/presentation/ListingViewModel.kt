package com.mordaski.challenge.feature.listing.presentation

import androidx.lifecycle.viewModelScope
import com.mordaski.challenge.common.base.BaseResult
import com.mordaski.challenge.common.base.BaseViewModel
import com.mordaski.challenge.common.model.Currency
import com.mordaski.challenge.feature.listing.domain.usecase.GetAvailableExchangeRatesUseCase
import com.mordaski.challenge.feature.listing.presentation.model.ListingViewAction
import com.mordaski.challenge.feature.listing.presentation.model.ListingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListingViewModel @Inject constructor(
    private val getAvailableExchangeRatesUseCase: GetAvailableExchangeRatesUseCase,
) : BaseViewModel<ListingViewState, ListingViewAction>() {

    override val viewState = ListingViewState()

    init {
        fetchData()
    }

    override fun dispatchViewAction(viewAction: ListingViewAction) {
        when (viewAction) {
            is ListingViewAction.Retry -> fetchData()
            is ListingViewAction.Retry -> fetchData()
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            getAvailableExchangeRatesUseCase.invoke()
                .onStart {
                    viewState.state.value = ListingViewState.State.Loading
                }
                .catch {
                    viewState.state.value = ListingViewState.State.Error(it.message)
                }
                .collect {
                    handleDataResult(it)
                }
        }
    }

    private fun handleDataResult(result: BaseResult<List<Currency>, String>) {
        viewState.state.value = when (result) {
            is BaseResult.Success -> ListingViewState.State.Splash(result.data)
            is BaseResult.Error -> ListingViewState.State.Error(result.rawResponse)
        }
    }
}

