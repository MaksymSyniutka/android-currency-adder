package eu.krzdabrowski.currencyadder.exchangerates.data.mapper

import eu.krzdabrowski.currencyadder.core.database.kotlin.room.model.ExchangeRateCached
import eu.krzdabrowski.currencyadder.exchangerates.domain.model.ExchangeRate
import eu.krzdabrowski.currencyadder.exchangerates.data.remote.model.ExchangeRatesResponse

internal fun List<ExchangeRatesResponse>.toDomainModels() = this[0].exchangeRates.map {
    ExchangeRate(
        currencyCode = it.code,
        currencyRate = it.rate,
    )
}

internal fun ExchangeRate.toEntityModel() = ExchangeRateCached(
    currencyCode = currencyCode,
    currencyRate = currencyRate,
)
