package eu.krzdabrowski.currencyadder.usersavings.domain.usecase

import eu.krzdabrowski.currencyadder.usersavings.domain.model.UserSaving

fun interface UpdateUserSavingUseCase : suspend (UserSaving) -> Result<Unit>
