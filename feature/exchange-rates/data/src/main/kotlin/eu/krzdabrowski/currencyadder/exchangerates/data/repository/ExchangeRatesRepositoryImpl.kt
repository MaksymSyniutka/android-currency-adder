package eu.krzdabrowski.currencyadder.exchangerates.data.repository

import eu.krzdabrowski.currencyadder.core.database.kotlin.room.dao.ExchangeRatesDao
import eu.krzdabrowski.currencyadder.core.database.kotlin.room.model.ExchangeRateCached
import eu.krzdabrowski.currencyadder.core.utils.resultOf
import eu.krzdabrowski.currencyadder.exchangerates.domain.repository.ExchangeRatesRepository
import eu.krzdabrowski.currencyadder.exchangerates.data.mapper.toDomainModels
import eu.krzdabrowski.currencyadder.exchangerates.data.mapper.toEntityModel
import eu.krzdabrowski.currencyadder.exchangerates.data.remote.api.ExchangeRatesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val BASE_EXCHANGE_RATE_CODE = "PLN"

internal class ExchangeRatesRepositoryImpl @Inject constructor(
    private val exchangeRatesApi: ExchangeRatesApi,
    private val exchangeRatesDao: ExchangeRatesDao,
) : ExchangeRatesRepository {

    override fun getAllCurrencyCodes(): Flow<Result<List<String>>> {
        return exchangeRatesDao
            .getAllCurrencyCodes()
            .map { Result.success(it) }
    }

    override suspend fun getCurrencyCodesThatStartWith(
        searchPhrase: String
    ): Result<List<String>> = resultOf {
        exchangeRatesDao
            .getCurrencyCodesThatStartWith("$searchPhrase%")
    }

    override suspend fun refreshExchangeRates(): Result<Unit> = resultOf {
        exchangeRatesApi
            .getExchangeRates()
            .toDomainModels()
            .map {
                it.toEntityModel()
            }
            .also {
                saveBaseExchangeRate()
            }
            .also { ratesToSave ->
                exchangeRatesDao.saveExchangeRates(
                    ratesToSave.sortedBy { it.currencyCode },
                )
            }
    }

    private suspend fun saveBaseExchangeRate(): Result<Unit> = resultOf {
        exchangeRatesDao.saveExchangeRates(
            listOf(
                ExchangeRateCached(
                    currencyCode = BASE_EXCHANGE_RATE_CODE,
                    currencyRate = 1.0,
                ),
            ),
        )
    }
}