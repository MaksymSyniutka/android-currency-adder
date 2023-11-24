package eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase

fun interface SwapUserSavingsUseCase : suspend (Long, Long) -> Result<Unit>
