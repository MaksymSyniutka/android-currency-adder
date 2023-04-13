package eu.krzdabrowski.currencyadder.basefeature.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import eu.krzdabrowski.currencyadder.basefeature.R
import eu.krzdabrowski.currencyadder.basefeature.presentation.CurrencyAdderUiState

@Composable
fun CurrencyAdderTotalSavingsContent(
    uiState: CurrencyAdderUiState,
    onGetTotalUserSavingsInChosenCurrency: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.total_amount),
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                text = uiState.totalUserSavings,
                modifier = Modifier.weight(3f),
                textAlign = TextAlign.Right,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.displaySmall
            )

            CurrencyAdderChosenCurrencyDropdownMenu(
                value = uiState.chosenCurrencyCode,
                currencyCodes = uiState.currencyCodes,
                modifier = Modifier.weight(1f),
                onCurrencyChange = onGetTotalUserSavingsInChosenCurrency
            )
        }
    }
}

@Composable
private fun CurrencyAdderChosenCurrencyDropdownMenu(
    value: String,
    currencyCodes: List<String>,
    modifier: Modifier = Modifier,
    onCurrencyChange: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier,
    ) {
        TextField(
            value = value,
            onValueChange = { },
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            ),
            shape = RectangleShape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            currencyCodes.forEach { code ->
                DropdownMenuItem(
                    text = { Text(code) },
                    onClick = {
                        onCurrencyChange(code)
                        expanded = false
                    },
                )
            }
        }
    }
}
