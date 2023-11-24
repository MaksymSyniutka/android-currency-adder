package eu.krzdabrowski.currencyadder.usersavings.impl.data.mapper

import eu.krzdabrowski.currencyadder.core.database.api.room.model.UserSavingCached
import eu.krzdabrowski.currencyadder.usersavings.api.domain.model.UserSaving

internal fun UserSavingCached.toDomainModel() = UserSaving(
    id = id,
    timestamp = timestamp,
    place = place,
    amount = amount,
    currency = currency,
)

internal fun UserSaving.toEntityModel() = UserSavingCached(
    id = id,
    timestamp = timestamp,
    place = place,
    amount = amount,
    currency = currency,
)
