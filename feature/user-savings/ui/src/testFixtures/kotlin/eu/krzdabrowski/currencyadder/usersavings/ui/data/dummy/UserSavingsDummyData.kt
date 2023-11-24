package eu.krzdabrowski.currencyadder.usersavings.ui.data.dummy

import eu.krzdabrowski.currencyadder.exchangerates.api.data.dummy.generateTestCurrencyCodesFromPresentation
import eu.krzdabrowski.currencyadder.usersavings.ui.model.UserSavingDisplayable

fun generateTestUserSavingsFromPresentation() = listOf(
    UserSavingDisplayable(
        id = 1,
        timestamp = 1684178192634L,
        place = "home",
        amount = "10.00",
        currency = "PLN",
        currencyPossibilities = generateTestCurrencyCodesFromPresentation(),
    ),
    UserSavingDisplayable(
        id = 2,
        timestamp = 1684178192635L,
        place = "bank",
        amount = "20.00",
        currency = "EUR",
        currencyPossibilities = listOf("GBP"),
    ),
    UserSavingDisplayable(
        id = 3,
        timestamp = 1684178192636L,
        place = "mattress",
        amount = "30.00",
        currency = "USD",
        currencyPossibilities = generateTestCurrencyCodesFromPresentation(),
    ),
)