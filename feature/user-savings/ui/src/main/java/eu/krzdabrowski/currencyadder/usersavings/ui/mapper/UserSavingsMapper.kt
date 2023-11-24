package eu.krzdabrowski.currencyadder.usersavings.ui.mapper

import eu.krzdabrowski.currencyadder.usersavings.api.domain.model.UserSaving
import eu.krzdabrowski.currencyadder.core.utils.toFormattedAmount
import eu.krzdabrowski.currencyadder.usersavings.ui.model.UserSavingDisplayable

private const val DEFAULT_SAVING_VALUE: Double = 0.0

fun UserSaving.toPresentationModel() = UserSavingDisplayable(
    id = id,
    timestamp = timestamp,
    place = place,
    amount = if (amount != DEFAULT_SAVING_VALUE) {
        amount.toFormattedAmount().removeSuffix(".00")
    } else {
        ""
    },
    currency = currency,
    currencyPossibilities = emptyList(),
)

fun UserSavingDisplayable.toDomainModel() = UserSaving(
    id = id,
    timestamp = timestamp,
    place = place,
    amount = amount.toDoubleOrNull() ?: 0.0,
    currency = currency,
)
