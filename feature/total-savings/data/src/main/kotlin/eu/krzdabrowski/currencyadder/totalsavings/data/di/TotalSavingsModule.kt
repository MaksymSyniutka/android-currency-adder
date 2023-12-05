package eu.krzdabrowski.currencyadder.totalsavings.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.krzdabrowski.currencyadder.totalsavings.domain.repository.TotalSavingsRepository
import eu.krzdabrowski.currencyadder.totalsavings.data.repository.TotalSavingsRepositoryImpl
import eu.krzdabrowski.currencyadder.totalsavings.domain.usecase.GetChosenCurrencyCodeForTotalSavingsUseCase
import eu.krzdabrowski.currencyadder.totalsavings.domain.usecase.GetTotalUserSavingsUseCase
import eu.krzdabrowski.currencyadder.totalsavings.domain.usecase.UpdateChosenCurrencyCodeForTotalSavingsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object TotalSavingsModule {

    @Provides
    fun provideGetTotalUserSavingsUseCase(
        totalSavingsRepository: TotalSavingsRepository,
    ) = GetTotalUserSavingsUseCase(totalSavingsRepository::getTotalUserSavings)

    @Provides
    fun provideGetChosenCurrencyCodeForTotalSavingsUseCase(
        totalSavingsRepository: TotalSavingsRepository,
    ) = GetChosenCurrencyCodeForTotalSavingsUseCase(totalSavingsRepository::getChosenCurrencyCodeForTotalSavings)

    @Provides
    fun provideUpdateChosenCurrencyCodeForTotalSavingsUseCase(
        totalSavingsRepository: TotalSavingsRepository,
    ) = UpdateChosenCurrencyCodeForTotalSavingsUseCase(totalSavingsRepository::updateChosenCurrencyCodeForTotalSavings)

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindTotalSavingsRepository(impl: TotalSavingsRepositoryImpl): TotalSavingsRepository
    }
}
