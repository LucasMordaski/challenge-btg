package com.mordaski.challenge.feature.conversion.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mordaski.challenge.common.compose.ErrorScreen
import com.mordaski.challenge.common.compose.LoadingScreen
import com.mordaski.challenge.common.theme.ChallengeTheme
import com.mordaski.challenge.feature.conversion.presentation.compose.CurrencyConverterScreen
import com.mordaski.challenge.feature.conversion.presentation.model.ConversionViewAction
import com.mordaski.challenge.feature.conversion.presentation.model.ConversionViewState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ConversionContainerScreen(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: ConversionViewModel = hiltViewModel()

    viewModel.viewState.state.collectAsState().value.also { state ->
        when (state) {
            is ConversionViewState.State.CurrencyConverterScreen -> CurrencyConverterScreen()
            is ConversionViewState.State.Loading -> LoadingScreen()
            is ConversionViewState.State.Error -> ErrorScreen(
                onTryAgain = { viewModel.dispatchViewAction(ConversionViewAction.Retry) }
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    ChallengeTheme {
        ConversionContainerScreen(navController = navController)
    }
}
