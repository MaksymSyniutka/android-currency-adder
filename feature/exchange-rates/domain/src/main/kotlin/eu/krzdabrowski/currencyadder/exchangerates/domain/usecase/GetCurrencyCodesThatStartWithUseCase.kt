package eu.krzdabrowski.currencyadder.exchangerates.domain.usecase

fun interface GetCurrencyCodesThatStartWithUseCase : suspend (String) -> Result<List<String>>
