package eu.krzdabrowski.currencyadder.core.database.android.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eu.krzdabrowski.currencyadder.core.database.kotlin.datastore.DataStoreManager
import eu.krzdabrowski.currencyadder.core.database.android.datastore.DataStoreManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            appContext.preferencesDataStoreFile("settings")
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Binds
        @Singleton
        fun bindDataStoreManager(impl: DataStoreManagerImpl): DataStoreManager
    }
}
