package eu.krzdabrowski.currencyadder.core.database.api.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    fun readString(key: String): Flow<String>

    suspend fun writeString(key: String, value: String)
}