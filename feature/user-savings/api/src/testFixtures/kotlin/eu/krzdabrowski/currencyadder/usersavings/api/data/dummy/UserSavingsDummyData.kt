package eu.krzdabrowski.currencyadder.usersavings.api.data.dummy

import eu.krzdabrowski.currencyadder.usersavings.api.domain.model.UserSaving

fun generateTestUserSavingsFromDomain() = listOf(
    UserSaving(
        id = 1,
        timestamp = 1684178192634L,
        place = "home",
        amount = 10.0,
        currency = "PLN",
    ),
    UserSaving(
        id = 2,
        timestamp = 1684178192635L,
        place = "bank",
        amount = 20.0,
        currency = "EUR",
    ),
    UserSaving(
        id = 3,
        timestamp = 1684178192636L,
        place = "mattress",
        amount = 30.0,
        currency = "USD",
    ),
)