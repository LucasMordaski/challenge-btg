package com.mordaski.challenge.common.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mordaski.challenge.R
import com.mordaski.challenge.common.theme.ChallengeTheme
import com.mordaski.challenge.feature.splash.presentation.model.SplashViewState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun LoadingScreen() {
    Scaffold(
        content = { padding ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btg_pactual),
                        contentDescription = "Logo Btg",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    Text(text = "Loading...")
                }
            }
        }
    )
}

@ExperimentalMaterial3Api
@Composable
fun DefaultPreview() {
    ChallengeTheme {
        LoadingScreen()
    }
}
