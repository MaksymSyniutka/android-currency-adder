package eu.krzdabrowski.currencyadder.exchangerates.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ExchangeRatesResponse(
    @SerialName("rates")
    val exchangeRates: List<ExchangeRate> = emptyList(),
) {
    @Serializable
    data class ExchangeRate(
        @SerialName("code")
        val code: String = "",

        @SerialName("mid")
        val rate: Double = 0.0,
    )
}
