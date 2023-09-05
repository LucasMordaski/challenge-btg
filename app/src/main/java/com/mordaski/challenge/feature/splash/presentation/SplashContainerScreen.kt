package com.mordaski.challenge.feature.splash.presentation

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
import com.mordaski.challenge.common.extensions.isInternetAvailable
import com.mordaski.challenge.common.navigation.Screens
import com.mordaski.challenge.common.theme.ChallengeTheme
import com.mordaski.challenge.feature.splash.presentation.model.SplashViewAction
import com.mordaski.challenge.feature.splash.presentation.model.SplashViewState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun SplashContainerScreen(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: SplashViewModel = hiltViewModel()

    viewModel.viewState.state.collectAsState().value.also { state ->
        when (state) {
            is SplashViewState.State.Splash ->
                if (state.conected) navController.navigate(Screens.Listing.route)
                else if (context.isInternetAvailable()) navController.navigate(Screens.Listing.route)
                else ErrorScreen(
                    title = "Sem conexão com a Internet",
                    subtitle = "Por favor, verifique sua conexão com a Internet e tente novamente.",
                    onTryAgain = { viewModel.dispatchViewAction(SplashViewAction.Retry) }
                )

            is SplashViewState.State.Loading -> LoadingScreen()
            is SplashViewState.State.Error -> ErrorScreen(
                onTryAgain = { viewModel.dispatchViewAction(SplashViewAction.Retry) }
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    ChallengeTheme {
        SplashContainerScreen(navController = navController)
    }
}
