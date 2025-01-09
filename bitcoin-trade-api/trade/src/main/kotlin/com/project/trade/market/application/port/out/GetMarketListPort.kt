package com.project.trade.market.application.port.out

import com.project.trade.market.adapter.`in`.web.MarketDto

interface GetMarketListPort {
    fun getMarketList(): List<MarketDto>
}