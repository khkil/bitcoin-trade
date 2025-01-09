package com.project.trade.market.application.port.`in`

import com.project.trade.market.domain.Candle

interface GetCandleListUseCase {
    fun getCandleList(candleCommand: CandleCommand): List<Candle.CandleData>
}