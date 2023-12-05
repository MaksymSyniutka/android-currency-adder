package eu.krzdabrowski.currencyadder.totalsavings.ui

sealed interface TotalSavingsIntent {
    data class UpdateChosenCurrencyCodeForTotalSavings(val currencyCode: String) :
        TotalSavingsIntent
}