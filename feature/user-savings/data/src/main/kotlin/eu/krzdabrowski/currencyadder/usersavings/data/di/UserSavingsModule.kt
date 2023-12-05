package eu.krzdabrowski.currencyadder.usersavings.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.krzdabrowski.currencyadder.usersavings.data.repository.UserSavingsRepositoryImpl
import eu.krzdabrowski.currencyadder.usersavings.domain.repository.UserSavingsRepository
import eu.krzdabrowski.currencyadder.usersavings.domain.usecase.AddUserSavingUseCase
import eu.krzdabrowski.currencyadder.usersavings.domain.usecase.GetUserSavingsUseCase
import eu.krzdabrowski.currencyadder.usersavings.domain.usecase.RemoveUserSavingUseCase
import eu.krzdabrowski.currencyadder.usersavings.domain.usecase.SwapUserSavingsUseCase
import eu.krzdabrowski.currencyadder.usersavings.domain.usecase.UpdateUserSavingUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object UserSavingsModule {

    @Provides
    fun provideGetUserSavingsUseCase(
        userSavingsRepository: UserSavingsRepository,
    ) = GetUserSavingsUseCase(userSavingsRepository::getUserSavings)

    @Provides
    fun provideAddUserSavingUseCase(
        userSavingsRepository: UserSavingsRepository,
    ) = AddUserSavingUseCase(userSavingsRepository::addUserSaving)

    @Provides
    fun provideUpdateUserSavingUseCase(
        userSavingsRepository: UserSavingsRepository,
    ) = UpdateUserSavingUseCase(userSavingsRepository::updateUserSaving)

    @Provides
    fun provideRemoveUserSavingUseCase(
        userSavingsRepository: UserSavingsRepository,
    ) = RemoveUserSavingUseCase(userSavingsRepository::removeUserSaving)

    @Provides
    fun provideSwapUserSavingsUseCase(
        userSavingsRepository: UserSavingsRepository,
    ) = SwapUserSavingsUseCase(userSavingsRepository::swapUserSavings)

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindUserSavingsRepository(impl: UserSavingsRepositoryImpl): UserSavingsRepository
    }
}
