package com.project.trade.common.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.Builder
import reactor.netty.http.client.HttpClient

@Component
class WebClientConfig {

    @Bean
    fun upbitOpenApiClient(builder: Builder): WebClient {
        return builder
            .baseUrl("https://api.upbit.com")
            .clientConnector(ReactorClientHttpConnector(HttpClient.create()))
            .defaultHeader("Content-Type", "application/json")
            .build()
    }

    fun <I, O> get(
        webClient: WebClient,
        url: String,
        params: I,
        response: ParameterizedTypeReference<O>
    ): O {
        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(response)
            .block() ?: throw RuntimeException("Failed to fetch data")
    }
}