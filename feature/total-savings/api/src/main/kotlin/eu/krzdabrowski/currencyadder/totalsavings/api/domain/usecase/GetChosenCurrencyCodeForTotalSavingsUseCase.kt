package eu.krzdabrowski.currencyadder.totalsavings.api.domain.usecase

import kotlinx.coroutines.flow.Flow

fun interface GetChosenCurrencyCodeForTotalSavingsUseCase : () -> Flow<Result<String>>
