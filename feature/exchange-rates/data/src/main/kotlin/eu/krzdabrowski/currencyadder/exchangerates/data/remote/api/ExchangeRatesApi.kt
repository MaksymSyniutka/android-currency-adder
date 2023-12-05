package eu.krzdabrowski.currencyadder.exchangerates.data.remote.api

import eu.krzdabrowski.currencyadder.exchangerates.data.remote.model.ExchangeRatesResponse
import retrofit2.http.GET

internal interface ExchangeRatesApi {

    @GET("exchangerates/tables/a")
    suspend fun getExchangeRates(): List<ExchangeRatesResponse>
}
