package eu.krzdabrowski.currencyadder.usersavings.impl.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import eu.krzdabrowski.currencyadder.usersavings.api.data.dummy.generateTestUserSavingsFromDomain
import eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase.AddUserSavingUseCase
import eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase.GetUserSavingsUseCase
import eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase.SwapUserSavingsUseCase
import eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase.UpdateUserSavingUseCase
import kotlinx.coroutines.flow.flowOf

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [UserSavingsModule::class],
)
internal object FakeUserSavingsModule {

    @Provides
    fun provideFakeGetUserSavingsUseCase() = GetUserSavingsUseCase {
        flowOf(
            Result.success(generateTestUserSavingsFromDomain()),
        )
    }

    @Provides
    fun provideNoopAddUserSavingUseCase() = AddUserSavingUseCase {
        Result.success(Unit)
    }

    @Provides
    fun provideNoopUpdateUserSavingUseCase() = UpdateUserSavingUseCase {
        Result.success(Unit)
    }

    @Provides
    fun provideNoopSwapUserSavingsUseCase() = SwapUserSavingsUseCase { _, _ ->
        Result.success(Unit)
    }
}