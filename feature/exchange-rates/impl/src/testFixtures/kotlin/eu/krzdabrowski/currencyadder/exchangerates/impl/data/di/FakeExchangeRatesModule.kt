package eu.krzdabrowski.currencyadder.exchangerates.impl.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import eu.krzdabrowski.currencyadder.exchangerates.api.domain.usecase.GetAllCurrencyCodesUseCase
import eu.krzdabrowski.currencyadder.exchangerates.api.domain.usecase.GetCurrencyCodesThatStartWithUseCase
import eu.krzdabrowski.currencyadder.exchangerates.api.domain.usecase.RefreshExchangeRatesUseCase
import kotlinx.coroutines.flow.flowOf

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ExchangeRatesModule::class],
)
internal object FakeExchangeRatesModule {

    @Provides
    fun provideNoopGetAllCurrencyCodesUseCase() = GetAllCurrencyCodesUseCase {
        flowOf(
            Result.success(emptyList()),
        )
    }

    @Provides
    fun provideNoopGetCurrencyCodesThatStartWithUseCase() = GetCurrencyCodesThatStartWithUseCase {
        Result.success(emptyList())
    }

    @Provides
    fun provideNoopRefreshExchangeRatesUseCase() = RefreshExchangeRatesUseCase {
        Result.success(Unit)
    }
}