package eu.krzdabrowski.currencyadder.totalsavings.api.domain.usecase

fun interface UpdateChosenCurrencyCodeForTotalSavingsUseCase : suspend (String) -> Result<Unit>
