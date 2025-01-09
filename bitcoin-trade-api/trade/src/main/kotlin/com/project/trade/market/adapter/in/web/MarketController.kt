package com.project.trade.market.adapter.`in`.web

import com.project.trade.market.application.port.`in`.CandleCommand
import com.project.trade.market.application.port.`in`.GetBitCoinListUseCase
import com.project.trade.market.application.port.`in`.GetCandleListUseCase
import com.project.trade.market.domain.Candle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/market")
class MarketController(
    private val getBitCoinListUseCase: GetBitCoinListUseCase,
    private val getCandleListUseCase: GetCandleListUseCase
) {
    @GetMapping("/all")
    fun getMarketList(): List<MarketDto> {
        return getBitCoinListUseCase.getBitcoinList();
    }

    @GetMapping("/candle")
    fun getCandleList(candleCommand: CandleCommand): List<Candle.CandleData> {
        return getCandleListUseCase.getCandleList(candleCommand);
    }
}