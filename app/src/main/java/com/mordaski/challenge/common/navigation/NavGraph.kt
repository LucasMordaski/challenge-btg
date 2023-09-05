package com.mordaski.challenge.common.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mordaski.challenge.feature.conversion.presentation.ConversionContainerScreen
import com.mordaski.challenge.feature.listing.presentation.ListingContainerScreen
import com.mordaski.challenge.feature.splash.presentation.SplashContainerScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    )
    {
        composable(route = Screens.Splash.route) {
            SplashContainerScreen(navController = navController)
        }
        composable(route = Screens.Conversion.route) {
            ConversionContainerScreen(navController = navController)
        }
        composable(route = Screens.Listing.route) {
            ListingContainerScreen(navController = navController)
        }
    }
}
