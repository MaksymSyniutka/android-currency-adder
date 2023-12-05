package eu.krzdabrowski.currencyadder.usersavings.domain.usecase

fun interface RemoveUserSavingUseCase : suspend (Long) -> Result<Unit>
