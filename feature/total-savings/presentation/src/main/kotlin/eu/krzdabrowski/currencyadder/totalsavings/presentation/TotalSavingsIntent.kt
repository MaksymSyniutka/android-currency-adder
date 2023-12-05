package eu.krzdabrowski.currencyadder.totalsavings.presentation

sealed interface TotalSavingsIntent {
    data class UpdateChosenCurrencyCodeForTotalSavings(val currencyCode: String) :
        TotalSavingsIntent
}