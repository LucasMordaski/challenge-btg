package com.mordaski.challenge.feature.conversion.presentation.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalMaterial3Api
@Composable
fun CurrencyConverterScreen() {

    var sourceCurrency by remember { mutableStateOf("USD") }
    var targetCurrency by remember { mutableStateOf("EUR") }
    var inputValue by remember { mutableStateOf("") }
    var convertedValue by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    val density = LocalDensity.current.density

    Column(
    modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)
    ) {
        // Choose Source Currency
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Source Currency:")
            Button(
                onClick = {
                    // Implement logic to show a currency selection dialog or screen
                }
            ) {
                Text(text = sourceCurrency)
            }
        }

        // Choose Target Currency
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Target Currency:")
            Button(
                onClick = {
                    // Implement logic to show a currency selection dialog or screen
                }
            ) {
                Text(text = targetCurrency)
            }
        }

        // Input Value
        BasicTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(56.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)),
            textStyle = TextStyle(fontSize = 18.sp)
        )

        // Convert Button
        Button(
            onClick = {
                // Implement currency conversion logic
                // Update the convertedValue state with the result
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Convert")
        }

        // Converted Value
        Text(
            text = convertedValue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            fontSize = 24.sp
        )
    }
}