package eu.krzdabrowski.currencyadder.exchangerates.domain.usecase

fun interface RefreshExchangeRatesUseCase : suspend () -> Result<Unit>
