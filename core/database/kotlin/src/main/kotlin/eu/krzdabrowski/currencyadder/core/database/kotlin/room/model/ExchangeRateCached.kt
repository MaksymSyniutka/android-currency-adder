package eu.krzdabrowski.currencyadder.core.database.kotlin.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exchange_Rates")
data class ExchangeRateCached(

    @PrimaryKey
    @ColumnInfo(name = "code")
    val currencyCode: String,

    @ColumnInfo(name = "value")
    val currencyRate: Double,
)
