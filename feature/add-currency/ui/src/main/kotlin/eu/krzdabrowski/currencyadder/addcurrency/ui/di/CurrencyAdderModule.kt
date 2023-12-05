package eu.krzdabrowski.currencyadder.addcurrency.ui.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import eu.krzdabrowski.currencyadder.addcurrency.ui.CurrencyAdderNavigationFactory
import eu.krzdabrowski.currencyadder.core.navigation.android.NavigationFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface CurrencyAdderModule {

    @Singleton
    @Binds
    @IntoSet
    fun bindCurrencyAdderNavigationFactory(factory: CurrencyAdderNavigationFactory): NavigationFactory
}
