package eu.krzdabrowski.currencyadder.exchangerates.domain.usecase

import kotlinx.coroutines.flow.Flow

fun interface GetAllCurrencyCodesUseCase : () -> Flow<Result<List<String>>>