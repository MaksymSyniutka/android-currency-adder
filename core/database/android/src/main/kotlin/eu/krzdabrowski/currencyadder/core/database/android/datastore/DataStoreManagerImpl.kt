package eu.krzdabrowski.currencyadder.core.database.android.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import eu.krzdabrowski.currencyadder.core.database.kotlin.datastore.DataStoreManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DataStoreManagerImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : DataStoreManager {
    override fun readString(key: String): Flow<String> = dataStore
        .data
        .map {
            it[stringPreferencesKey(key)] ?: ""
        }

    override suspend fun writeString(key: String, value: String) {
        dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }
}
