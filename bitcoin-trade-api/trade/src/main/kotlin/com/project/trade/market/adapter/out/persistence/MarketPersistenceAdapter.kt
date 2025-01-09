package com.project.trade.market.adapter.out.persistence

import com.project.trade.common.config.WebClientConfig
import com.project.trade.market.adapter.`in`.web.MarketDto
import com.project.trade.market.application.port.out.GetMarketListPort
import com.project.trade.market.application.port.out.GetCandlePort
import com.project.trade.market.domain.Candle
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.time.LocalDateTime

@Component
class MarketPersistenceAdapter(
    private val upbitWebClient: WebClient,
    private val webClientConfig: WebClientConfig
) : GetMarketListPort, GetCandlePort {

    override fun getMarketList(): List<MarketDto> {
        val typeReference = object : ParameterizedTypeReference<List<MarketDto>>() {}
        return webClientConfig.get(upbitWebClient, "/v1/market/all", null, typeReference)
    }

    override fun getCandleListPerSecond(params: Candle.Params): List<Candle.CandleData> {
        val typeReference = object : ParameterizedTypeReference<List<Candle.CandleData>>() {}
        return webClientConfig.get(upbitWebClient, "/v1/candles/seconds", params, typeReference)
    }
}