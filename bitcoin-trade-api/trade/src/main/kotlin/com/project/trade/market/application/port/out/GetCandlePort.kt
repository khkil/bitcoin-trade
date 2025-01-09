package com.project.trade.market.application.port.out

import com.project.trade.market.domain.Candle
import java.time.LocalDateTime

interface GetCandlePort {
    fun getCandleListPerSecond(params: Candle.Params): List<Candle.CandleData>
}