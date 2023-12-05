package eu.krzdabrowski.currencyadder.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import eu.krzdabrowski.currencyadder.core.navigation.NavigationDestination.CurrencyAdder

@Composable
fun NavigationHost(
    navController: NavHostController,
    factories: Set<NavigationFactory>,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = CurrencyAdder.route,
        modifier = modifier,
    ) {
        factories.forEach {
            it.create(this)
        }
    }
}
