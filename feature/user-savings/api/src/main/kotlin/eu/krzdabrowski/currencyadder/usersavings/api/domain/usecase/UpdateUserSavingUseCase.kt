package eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase

import eu.krzdabrowski.currencyadder.usersavings.api.domain.model.UserSaving

fun interface UpdateUserSavingUseCase : suspend (UserSaving) -> Result<Unit>
