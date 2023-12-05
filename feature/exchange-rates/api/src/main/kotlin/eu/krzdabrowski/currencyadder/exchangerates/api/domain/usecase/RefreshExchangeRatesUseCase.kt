package eu.krzdabrowski.currencyadder.exchangerates.api.domain.usecase

fun interface RefreshExchangeRatesUseCase : suspend () -> Result<Unit>
