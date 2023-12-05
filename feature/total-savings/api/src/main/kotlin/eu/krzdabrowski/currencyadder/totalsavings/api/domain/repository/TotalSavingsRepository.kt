package eu.krzdabrowski.currencyadder.totalsavings.api.domain.repository

import kotlinx.coroutines.flow.Flow

interface TotalSavingsRepository {

    fun getTotalUserSavings(): Flow<Result<Double>>

    fun getChosenCurrencyCodeForTotalSavings(): Flow<Result<String>>

    suspend fun updateChosenCurrencyCodeForTotalSavings(currencyCode: String): Result<Unit>
}
