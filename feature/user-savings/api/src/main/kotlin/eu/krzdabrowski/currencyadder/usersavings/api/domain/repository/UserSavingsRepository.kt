package eu.krzdabrowski.currencyadder.usersavings.api.domain.repository

import eu.krzdabrowski.currencyadder.usersavings.api.domain.model.UserSaving
import kotlinx.coroutines.flow.Flow

interface UserSavingsRepository {

    fun getUserSavings(): Flow<Result<List<UserSaving>>>

    suspend fun addUserSaving(userSaving: UserSaving): Result<Unit>

    suspend fun updateUserSaving(userSaving: UserSaving): Result<Unit>

    suspend fun removeUserSaving(userSavingId: Long): Result<Unit>

    suspend fun swapUserSavings(fromIndex: Long, toIndex: Long): Result<Unit>
}
