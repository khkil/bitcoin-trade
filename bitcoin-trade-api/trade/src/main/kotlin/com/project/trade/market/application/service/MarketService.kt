package com.project.trade.market.application.service

import com.project.trade.common.enums.CandleType
import com.project.trade.market.adapter.`in`.web.MarketDto
import com.project.trade.market.application.port.`in`.CandleCommand
import com.project.trade.market.application.port.`in`.GetBitCoinListUseCase
import com.project.trade.market.application.port.`in`.GetCandleListUseCase
import com.project.trade.market.application.port.out.GetMarketListPort
import com.project.trade.market.application.port.out.GetCandlePort
import com.project.trade.market.domain.Candle
import org.springframework.stereotype.Service

@Service
class MarketService(
    private val getMarketListPort: GetMarketListPort,
    private val getCandlePort: GetCandlePort,
) : GetBitCoinListUseCase,
    GetCandleListUseCase {
    override fun getBitcoinList(): List<MarketDto> {
        return getMarketListPort.getMarketList()
    }

    override fun getCandleList(candleCommand: CandleCommand): List<Candle.CandleData> {
        val candleType: CandleType = candleCommand.candleType
        
        val params: Candle.Params = Candle.Params(
            candleCommand.market,
            candleCommand.count,
            candleCommand.to
        )

        when (candleType) {
            CandleType.SECOND -> return getCandlePort.getCandleListPerSecond(params)
            CandleType.MINUTE -> TODO()
            CandleType.HOUR -> TODO()
        }
    }
}