package com.mordaski.challenge.common.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ErrorScreen(
    title: String? = "Ops, tivemos um problema!",
    subtitle: String? = null,
    buttonText: String = "Tentar novamente",
    onTryAgain: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(color = Color(0xFF05132a)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxHeight(),

            ) {
            ErrorMessage(title, subtitle)
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .padding(16.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = onTryAgain
            ) {
                Text(
                    text = buttonText.uppercase(),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }

    }
}

@Composable
fun ErrorMessage(firstText: String?, secondText: String?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        firstText?.let {
            Text(
                text = firstText,
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                fontWeight = Bold,
                color = Color.White
            )
        }
        secondText?.let {
            Text(
                text = it,
                fontSize = 20.sp,
                fontWeight = Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 15.dp, start = 24.dp, end = 24.dp),
                color = Color.White
            )
        }
    }
}


@Preview
@Composable
fun Preview() {
    ErrorScreen(
        title = "Erro 1",
        subtitle = "Algo deu errado tente novamente mais tarde",
        buttonText = "tentar novamente"
    ) { }
}

