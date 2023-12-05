package eu.krzdabrowski.currencyadder.totalsavings.domain.usecase

import kotlinx.coroutines.flow.Flow

fun interface GetTotalUserSavingsUseCase : () -> Flow<Result<Double>>
