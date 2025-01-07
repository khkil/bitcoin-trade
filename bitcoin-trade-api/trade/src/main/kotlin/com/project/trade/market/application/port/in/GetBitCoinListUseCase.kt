package com.project.trade.market.application.port.`in`

import com.project.trade.market.adapter.`in`.web.BitCoinDto

interface GetBitCoinListUseCase {
    fun getBitcoinList(): List<BitCoinDto>
}