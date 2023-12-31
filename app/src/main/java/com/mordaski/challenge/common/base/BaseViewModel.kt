package com.mordaski.challenge.common.base

import androidx.lifecycle.ViewModel

interface PresentationModel<T,A> {
    val viewState: T

    fun dispatchViewAction(viewAction: A)
}

abstract class BaseViewModel<T,A> : ViewModel(), PresentationModel<T, A>