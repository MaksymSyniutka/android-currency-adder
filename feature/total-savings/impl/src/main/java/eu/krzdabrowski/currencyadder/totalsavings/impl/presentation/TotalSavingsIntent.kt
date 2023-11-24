package eu.krzdabrowski.currencyadder.totalsavings.impl.presentation

sealed interface TotalSavingsIntent {
    data class UpdateChosenCurrencyCodeForTotalSavings(val currencyCode: String) :
        TotalSavingsIntent
}