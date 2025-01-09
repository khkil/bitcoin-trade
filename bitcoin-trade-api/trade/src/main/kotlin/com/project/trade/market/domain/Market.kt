package com.project.trade.market.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Market(
    @JsonProperty("market") val market: String,
)
