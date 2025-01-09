package com.project.trade.market.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class Candle {
    data class CandleData(
        @JsonProperty("market") val market: String,
        @JsonProperty("candle_date_time_utc") val candleDateTimeUtc: String,
        @JsonProperty("candle_date_time_kst") val candleDateTimeKst: String,
        @JsonProperty("opening_price") val openingPrice: Double,
        @JsonProperty("high_price") val highPrice: Double,
        @JsonProperty("low_price") val lowPrice: Double,
        @JsonProperty("trade_price") val tradePrice: Double,
        @JsonProperty("timestamp") val timestamp: Long,
        @JsonProperty("candle_acc_trade_price") val candleAccTradePrice: Double,
        @JsonProperty("candle_acc_trade_volume") val candleAccTradeVolume: Double
    )

    data class Params(
        val market: String,
        val count: Int? = 200,
        val to: LocalDateTime? = LocalDateTime.now()
    )
}