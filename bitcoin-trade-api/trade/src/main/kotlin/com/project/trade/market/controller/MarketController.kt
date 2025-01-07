package com.project.trade.market.controller

import com.project.trade.common.config.UpbitWebClientConfig
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/market")
class MarketController {
    @GetMapping
    fun market(upbitWebClient: UpbitWebClientConfig): ResponseEntity<String> {
        return ResponseEntity.ok("Market")
    }
}