package eu.krzdabrowski.currencyadder.usersavings.domain.usecase

fun interface SwapUserSavingsUseCase : suspend (Long, Long) -> Result<Unit>
