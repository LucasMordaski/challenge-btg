package com.mordaski.challenge.common.factory

import com.mordaski.challenge.common.model.Currency
import com.mordaski.challenge.common.model.Price

object MockFactory {

    fun makeList() = arrayListOf(
        Currency("USD", "United States Dollar"),
        Currency("EUR", "Euro"),
        Currency("BRL", "Real"),
    )

    fun makePrice() = arrayListOf(
        Price("USD", 4.9376, 1.0, 0.9262),
        Price("EUR", 5.3460, 1.0796, 1.0),
        Price("BRL", 1.0, 0.2025, 0.2025),
    )
}