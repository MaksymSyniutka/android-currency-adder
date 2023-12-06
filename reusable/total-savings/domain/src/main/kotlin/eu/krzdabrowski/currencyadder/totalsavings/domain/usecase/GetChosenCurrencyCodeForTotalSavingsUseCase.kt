package eu.krzdabrowski.currencyadder.totalsavings.domain.usecase

import kotlinx.coroutines.flow.Flow

fun interface GetChosenCurrencyCodeForTotalSavingsUseCase : () -> Flow<Result<String>>
