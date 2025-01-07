package com.project.trade.market.application.service

import com.project.trade.market.adapter.`in`.web.BitCoinDto
import com.project.trade.market.application.port.`in`.GetBitCoinListUseCase
import com.project.trade.market.application.port.out.GetBitcoinListPort
import org.springframework.stereotype.Service

@Service
class MarketService(private val getBitcoinListPort: GetBitcoinListPort) : GetBitCoinListUseCase {
    override fun getBitcoinList(): List<BitCoinDto> {
        return getBitcoinListPort.getBitcoinList()
    }
}