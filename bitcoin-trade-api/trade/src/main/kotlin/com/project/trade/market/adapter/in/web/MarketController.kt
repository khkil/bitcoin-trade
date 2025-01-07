package com.project.trade.market.adapter.`in`.web

import com.project.trade.market.application.port.`in`.GetBitCoinListUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/market")
class MarketController(private val getBitCoinListUseCase: GetBitCoinListUseCase) {
    @GetMapping("/all")
    fun getBitcoinList(): List<BitCoinDto> {
        return getBitCoinListUseCase.getBitcoinList();
    }
}