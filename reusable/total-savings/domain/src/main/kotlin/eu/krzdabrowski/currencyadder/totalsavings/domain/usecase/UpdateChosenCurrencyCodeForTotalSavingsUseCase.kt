package eu.krzdabrowski.currencyadder.totalsavings.domain.usecase

fun interface UpdateChosenCurrencyCodeForTotalSavingsUseCase : suspend (String) -> Result<Unit>
