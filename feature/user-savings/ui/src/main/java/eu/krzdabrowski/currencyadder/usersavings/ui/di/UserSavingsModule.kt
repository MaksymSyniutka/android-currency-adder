package eu.krzdabrowski.currencyadder.usersavings.ui.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import eu.krzdabrowski.currencyadder.usersavings.ui.UserSavingsUiState

@Module
@InstallIn(ViewModelComponent::class)
internal object UserSavingsModule {

    @Provides
    fun provideInitialUserSavingsUiState(): UserSavingsUiState = UserSavingsUiState()
}
