package com.project.trade.market.application.port.`in`

import com.project.trade.common.enums.CandleType
import java.time.LocalDateTime

data class CandleCommand(
    val candleType: CandleType,
    val market: String,
    val to: LocalDateTime?,
    val count: Int?,
)
