package eu.krzdabrowski.currencyadder.exchangerates.data

import eu.krzdabrowski.currencyadder.core.database.kotlin.room.model.ExchangeRateCached
import eu.krzdabrowski.currencyadder.exchangerates.data.remote.model.ExchangeRatesResponse
import eu.krzdabrowski.currencyadder.exchangerates.data.remote.model.ExchangeRatesResponse.ExchangeRate

internal fun generateTestBaseExchangeRateCached() = ExchangeRateCached(
    currencyCode = "PLN",
    currencyRate = 1.0,
)

internal fun generateTestExchangeRatesFromRemote() = ExchangeRatesResponse(
    exchangeRates = listOf(
        ExchangeRate(
            code = "USD",
            rate = 4.5276,
        ),
    ),
)

internal fun generateTestCurrencyCodesFromDomain() = listOf(
    "PLN",
    "USD",
    "EUR",
    "GBP",
)
