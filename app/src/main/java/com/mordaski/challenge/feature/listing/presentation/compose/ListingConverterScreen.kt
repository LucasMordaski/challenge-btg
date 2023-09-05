import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mordaski.challenge.common.factory.MockFactory
import com.mordaski.challenge.common.model.Currency
import com.mordaski.challenge.feature.listing.presentation.model.ListingViewAction

@Composable
fun ListingConverterScreen(
    availableCurrencies: List<Currency>,
    onCurrencySelected: (Currency, Currency) -> Unit
) {
    var selectedFromCurrency by remember { mutableStateOf(availableCurrencies.first()) }
    var selectedToCurrency by remember { mutableStateOf(availableCurrencies.first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Converter Moeda",
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            CurrencySelection(
                label = "De",
                selectedCurrency = selectedFromCurrency,
                availableCurrencies = availableCurrencies,
                onCurrencySelected = { currency ->
                    selectedFromCurrency = currency
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            CurrencySelection(
                label = "Para",
                selectedCurrency = selectedToCurrency,
                availableCurrencies = availableCurrencies,
                onCurrencySelected = { currency ->
                    selectedToCurrency = currency
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                onCurrencySelected(selectedFromCurrency, selectedToCurrency)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Converter")
        }
    }
}

@Composable
fun CurrencySelection(
    label: String,
    selectedCurrency: Currency,
    availableCurrencies: List<Currency>,
    onCurrencySelected: (Currency) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(text = label)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clickable { expanded = true }
        ) {
            Text(
                text = "${selectedCurrency.code} - ${selectedCurrency.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                availableCurrencies.forEach {
                    DropdownMenuItem(
                        text = { Text("${selectedCurrency.code} - ${selectedCurrency.name}") },
                        onClick = { },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Edit,
                                contentDescription = null
                            )
                        })
                }
            }
        }
    }
}


@Preview
@Composable
fun CurrencyConverterPreview() {
    ListingConverterScreen(
        availableCurrencies = MockFactory.makeList(),
        onCurrencySelected = { a, b -> }
    )
}
