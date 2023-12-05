package eu.krzdabrowski.currencyadder.totalsavings.api.domain.usecase

import kotlinx.coroutines.flow.Flow

fun interface GetTotalUserSavingsUseCase : () -> Flow<Result<Double>>
