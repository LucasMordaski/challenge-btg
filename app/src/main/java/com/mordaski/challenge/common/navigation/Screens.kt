package com.mordaski.challenge.common.navigation

sealed class Screens(val route: String) {
    object Splash: Screens("splash_screen")
    object Conversion: Screens("conversion_screen")
    object Listing: Screens("listing_screen")
}