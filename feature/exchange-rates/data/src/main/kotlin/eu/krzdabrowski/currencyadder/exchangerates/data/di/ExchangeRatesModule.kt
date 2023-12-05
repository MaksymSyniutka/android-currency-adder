package eu.krzdabrowski.currencyadder.exchangerates.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.krzdabrowski.currencyadder.exchangerates.domain.repository.ExchangeRatesRepository
import eu.krzdabrowski.currencyadder.exchangerates.domain.usecase.GetAllCurrencyCodesUseCase
import eu.krzdabrowski.currencyadder.exchangerates.domain.usecase.GetCurrencyCodesThatStartWithUseCase
import eu.krzdabrowski.currencyadder.exchangerates.domain.usecase.RefreshExchangeRatesUseCase
import eu.krzdabrowski.currencyadder.exchangerates.data.remote.api.ExchangeRatesApi
import eu.krzdabrowski.currencyadder.exchangerates.data.repository.ExchangeRatesRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ExchangeRatesModule {

    @Provides
    @Singleton
    fun provideExchangeRatesApi(
        retrofit: Retrofit,
    ): ExchangeRatesApi = retrofit.create(
        ExchangeRatesApi::class.java
    )

    @Provides
    fun provideGetAllCurrencyCodesUseCase(
        exchangeRatesRepository: ExchangeRatesRepository,
    ) = GetAllCurrencyCodesUseCase(
        exchangeRatesRepository::getAllCurrencyCodes
    )

    @Provides
    fun provideGetCurrencyCodesThatStartWithUseCase(
        exchangeRatesRepository: ExchangeRatesRepository,
    ) = GetCurrencyCodesThatStartWithUseCase(
        exchangeRatesRepository::getCurrencyCodesThatStartWith
    )

    @Provides
    fun provideRefreshExchangeRatesUseCase(
        exchangeRatesRepository: ExchangeRatesRepository,
    ) = RefreshExchangeRatesUseCase(
        exchangeRatesRepository::refreshExchangeRates
    )

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindExchangeRatesRepository(impl: ExchangeRatesRepositoryImpl): ExchangeRatesRepository
    }
}
