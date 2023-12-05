package eu.krzdabrowski.currencyadder.exchangerates.api.domain.model

data class ExchangeRate(
    val currencyCode: String,
    val currencyRate: Double,
)
