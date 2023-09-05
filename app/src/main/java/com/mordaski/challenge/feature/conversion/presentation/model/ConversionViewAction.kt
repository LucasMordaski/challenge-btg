package com.mordaski.challenge.feature.conversion.presentation.model

sealed class ConversionViewAction {
    object Retry : ConversionViewAction()
}