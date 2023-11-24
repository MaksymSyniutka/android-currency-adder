package eu.krzdabrowski.currencyadder.totalsavings.impl.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import eu.krzdabrowski.currencyadder.totalsavings.api.domain.usecase.GetChosenCurrencyCodeForTotalSavingsUseCase
import eu.krzdabrowski.currencyadder.totalsavings.api.domain.usecase.GetTotalUserSavingsUseCase
import eu.krzdabrowski.currencyadder.totalsavings.api.domain.usecase.UpdateChosenCurrencyCodeForTotalSavingsUseCase
import kotlinx.coroutines.flow.flowOf

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [TotalSavingsModule::class],
)
internal object FakeTotalSavingsModule {

    @Provides
    fun provideNoopGetTotalUserSavingsUseCase() = GetTotalUserSavingsUseCase {
        flowOf(
            Result.success(0.0),
        )
    }

    @Provides
    fun provideNoopGetChosenCurrencyCodeForTotalSavingsUseCase() =
        GetChosenCurrencyCodeForTotalSavingsUseCase {
            flowOf(
                Result.success("PLN"),
            )
        }

    @Provides
    fun provideNoopUpdateChosenCurrencyCodeForTotalUserSavingsUseCase() =
        UpdateChosenCurrencyCodeForTotalSavingsUseCase {
            Result.success(Unit)
        }
}