package eu.krzdabrowski.currencyadder.core.navigation.android

import androidx.navigation.NavOptions

interface NavigationCommand {
    val destination: String
    val configuration: NavOptions
        get() = NavOptions.Builder().build()
}
