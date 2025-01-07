package com.project.trade.market.application.port.out

import com.project.trade.market.adapter.`in`.web.BitCoinDto

interface GetBitcoinListPort {
    fun getBitcoinList(): List<BitCoinDto>
}