package com.mordaski.challenge.feature.listing.presentation

import ListingConverterScreen
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mordaski.challenge.common.compose.ErrorScreen
import com.mordaski.challenge.common.compose.LoadingScreen
import com.mordaski.challenge.common.theme.ChallengeTheme
import com.mordaski.challenge.feature.listing.presentation.model.ListingViewAction
import com.mordaski.challenge.feature.listing.presentation.model.ListingViewState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ListingContainerScreen(navController: NavHostController) {
    val viewModel: ListingViewModel = hiltViewModel()

    viewModel.viewState.state.collectAsState().value.also { state ->
        when (state) {
            is ListingViewState.State.Splash -> ListingConverterScreen(
                availableCurrencies = state.list
            ) { from, to ->
                viewModel.dispatchViewAction(ListingViewAction.onSelected(from, to))
            }
            is ListingViewState.State.Loading -> LoadingScreen()
            is ListingViewState.State.Error -> ErrorScreen(
                onTryAgain = { viewModel.dispatchViewAction(ListingViewAction.Retry) }
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    ChallengeTheme {
        ListingContainerScreen(navController = navController)
    }
}
