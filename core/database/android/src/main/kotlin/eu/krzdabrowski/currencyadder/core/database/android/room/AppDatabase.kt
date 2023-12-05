package eu.krzdabrowski.currencyadder.core.database.android.room

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.krzdabrowski.currencyadder.core.database.kotlin.room.dao.ExchangeRatesDao
import eu.krzdabrowski.currencyadder.core.database.kotlin.room.dao.UserSavingsDao
import eu.krzdabrowski.currencyadder.core.database.kotlin.room.model.ExchangeRateCached
import eu.krzdabrowski.currencyadder.core.database.kotlin.room.model.UserSavingCached

private const val DATABASE_VERSION = 2

@Database(
    version = DATABASE_VERSION,
    entities = [ExchangeRateCached::class, UserSavingCached::class],
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun exchangeRatesDao(): ExchangeRatesDao

    abstract fun userSavingsDao(): UserSavingsDao
}