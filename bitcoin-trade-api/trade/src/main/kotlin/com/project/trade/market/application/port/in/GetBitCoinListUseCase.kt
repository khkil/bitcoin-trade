package com.project.trade.market.application.port.`in`

import com.project.trade.market.adapter.`in`.web.MarketDto

interface GetBitCoinListUseCase {
    fun getBitcoinList(): List<MarketDto>
}