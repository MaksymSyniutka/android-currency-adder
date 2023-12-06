package eu.krzdabrowski.currencyadder.usersavings.domain.usecase

import eu.krzdabrowski.currencyadder.usersavings.domain.model.UserSaving
import kotlinx.coroutines.flow.Flow

fun interface GetUserSavingsUseCase : () -> Flow<Result<List<UserSaving>>>
