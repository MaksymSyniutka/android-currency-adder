package eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase

fun interface RemoveUserSavingUseCase : suspend (Long) -> Result<Unit>
