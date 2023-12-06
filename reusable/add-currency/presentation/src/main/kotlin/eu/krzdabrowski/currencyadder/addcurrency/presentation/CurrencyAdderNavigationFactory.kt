package eu.krzdabrowski.currencyadder.addcurrency.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import eu.krzdabrowski.currencyadder.core.navigation.NavigationDestination.CurrencyAdder
import eu.krzdabrowski.currencyadder.core.navigation.NavigationFactory
import javax.inject.Inject

internal class CurrencyAdderNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(CurrencyAdder.route) {
            CurrencyAdderRoute()
        }
    }
}
