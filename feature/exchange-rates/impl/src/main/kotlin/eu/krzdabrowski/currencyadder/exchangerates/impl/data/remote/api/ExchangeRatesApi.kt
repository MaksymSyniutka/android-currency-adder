package eu.krzdabrowski.currencyadder.exchangerates.impl.data.remote.api

import eu.krzdabrowski.currencyadder.exchangerates.impl.data.remote.model.ExchangeRatesResponse
import retrofit2.http.GET

internal interface ExchangeRatesApi {

    @GET("exchangerates/tables/a")
    suspend fun getExchangeRates(): List<ExchangeRatesResponse>
}
