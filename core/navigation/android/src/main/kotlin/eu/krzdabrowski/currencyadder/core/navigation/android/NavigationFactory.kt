package eu.krzdabrowski.currencyadder.core.navigation.android

import androidx.navigation.NavGraphBuilder

interface NavigationFactory {
    fun create(builder: NavGraphBuilder)
}
