package eu.krzdabrowski.currencyadder.usersavings.domain.usecase

import eu.krzdabrowski.currencyadder.usersavings.domain.model.UserSaving

fun interface AddUserSavingUseCase : suspend (UserSaving) -> Result<Unit>
