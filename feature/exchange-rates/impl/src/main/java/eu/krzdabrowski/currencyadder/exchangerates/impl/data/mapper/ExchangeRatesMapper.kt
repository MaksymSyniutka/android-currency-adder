package eu.krzdabrowski.currencyadder.exchangerates.impl.data.mapper

import eu.krzdabrowski.currencyadder.core.database.api.room.model.ExchangeRateCached
import eu.krzdabrowski.currencyadder.exchangerates.api.domain.model.ExchangeRate
import eu.krzdabrowski.currencyadder.exchangerates.impl.data.remote.model.ExchangeRatesResponse

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
