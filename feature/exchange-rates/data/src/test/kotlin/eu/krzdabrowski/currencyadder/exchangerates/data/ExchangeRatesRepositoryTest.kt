package eu.krzdabrowski.currencyadder.exchangerates.data

import eu.krzdabrowski.currencyadder.core.database.kotlin.room.dao.ExchangeRatesDao
import eu.krzdabrowski.currencyadder.exchangerates.domain.repository.ExchangeRatesRepository
import eu.krzdabrowski.currencyadder.exchangerates.data.mapper.toDomainModels
import eu.krzdabrowski.currencyadder.exchangerates.data.mapper.toEntityModel
import eu.krzdabrowski.currencyadder.exchangerates.data.remote.api.ExchangeRatesApi
import eu.krzdabrowski.currencyadder.exchangerates.data.repository.ExchangeRatesRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifyOrder
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExchangeRatesRepositoryTest {

    @RelaxedMockK
    private lateinit var exchangeRatesApi: ExchangeRatesApi

    @RelaxedMockK
    private lateinit var exchangeRatesDao: ExchangeRatesDao

    private lateinit var objectUnderTest: ExchangeRatesRepository

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        setUpExchangeRatesRepository()
    }

    @Test
    fun `should save sorted exchange rates locally with base exchange rate first`() = runTest {
        // Given
        val testBaseExchangeRateCached = listOf(generateTestBaseExchangeRateCached())
        val testExchangeRatesFromRemote = listOf(generateTestExchangeRatesFromRemote())
        val testExchangeRatesToCacheSorted = testExchangeRatesFromRemote
            .toDomainModels()
            .map { it.toEntityModel() }
            .sortedBy { it.currencyCode }

        coEvery { exchangeRatesApi.getExchangeRates() } returns testExchangeRatesFromRemote

        // When
        objectUnderTest.refreshExchangeRates()

        // Then
        coVerifyOrder {
            exchangeRatesDao.saveExchangeRates(
                testBaseExchangeRateCached,
            )
            exchangeRatesDao.saveExchangeRates(
                testExchangeRatesToCacheSorted,
            )
        }
    }

    @Test
    fun `should add percentage symbol at the end of search phrase when filtering currency codes`() = runTest {
        // Given
        val testPhrase = "PL"
        val testPhraseWithPercentageSymbol = "$testPhrase%"

        // When
        objectUnderTest.getCurrencyCodesThatStartWith(testPhrase)

        // Then
        coVerify {
            exchangeRatesDao.getCurrencyCodesThatStartWith(testPhraseWithPercentageSymbol)
        }
    }

    private fun setUpExchangeRatesRepository() {
        objectUnderTest = ExchangeRatesRepositoryImpl(
            exchangeRatesApi,
            exchangeRatesDao,
        )
    }
}
