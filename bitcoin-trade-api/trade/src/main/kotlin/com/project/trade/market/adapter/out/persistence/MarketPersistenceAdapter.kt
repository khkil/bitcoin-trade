package com.project.trade.market.adapter.out.persistence

import com.project.trade.common.config.WebClientConfig
import com.project.trade.market.adapter.`in`.web.BitCoinDto
import com.project.trade.market.application.port.out.GetBitcoinListPort
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class MarketPersistenceAdapter(
    private val upbitWebClient: WebClient,
    private val webClientConfig: WebClientConfig
) : GetBitcoinListPort {

    override fun getBitcoinList(): List<BitCoinDto> {
        val typeReference = object : ParameterizedTypeReference<List<BitCoinDto>>() {}
        return webClientConfig.get(upbitWebClient, "/v1/market/all", null, typeReference)
    }
}