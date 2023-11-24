package eu.krzdabrowski.currencyadder.exchangerates.api.domain.usecase

fun interface GetCurrencyCodesThatStartWithUseCase : suspend (String) -> Result<List<String>>
