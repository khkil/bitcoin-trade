package com.project.trade.market.adapter.`in`.web

import com.fasterxml.jackson.annotation.JsonProperty

data class MarketDto(
    @JsonProperty("market") val market: String,
    @JsonProperty("korean_name") val koreanName: String,
    @JsonProperty("english_name") val englishName: String,
)
