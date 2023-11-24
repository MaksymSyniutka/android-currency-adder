package eu.krzdabrowski.currencyadder.usersavings.api.domain.usecase

import eu.krzdabrowski.currencyadder.usersavings.api.domain.model.UserSaving
import kotlinx.coroutines.flow.Flow

fun interface GetUserSavingsUseCase : () -> Flow<Result<List<UserSaving>>>
