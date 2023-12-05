package eu.krzdabrowski.currencyadder.exchangerates.domain.model

data class ExchangeRate(
    val currencyCode: String,
    val currencyRate: Double,
)
