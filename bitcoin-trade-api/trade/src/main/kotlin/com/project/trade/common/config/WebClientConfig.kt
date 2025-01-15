package com.project.trade.common.config

import aj.org.objectweb.asm.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.project.trade.auth.application.port.out.GetAccessTokenPort
import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.Builder
import reactor.netty.http.client.HttpClient
import kotlin.reflect.full.memberProperties

@Component
class WebClientConfig(
    private val getAccessTokenPort: GetAccessTokenPort,
    private val objectMapper: ObjectMapper
) {

    @Bean
    fun upbitOpenApiClient(builder: Builder): WebClient {
        val accessToken: String = getAccessTokenPort.getAccessToken()

        return builder
            .exchangeStrategies(
                ExchangeStrategies
                    .builder()
                    .codecs {
                        it.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON))
                        it.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON))
                    }
                    .build()
            )
            .baseUrl("https://api.upbit.com")
            .clientConnector(ReactorClientHttpConnector(HttpClient.create()))
            .defaultHeader("Content-Type", "application/json")
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer $accessToken")
            .build()
    }

    fun <I, O> get(
        webClient: WebClient,
        url: String,
        params: I?,
        response: ParameterizedTypeReference<O>
    ): O {
        return webClient.get()
            .uri { urlBuilder ->
                urlBuilder.path(url)
                if (params != null) {
                    urlBuilder.queryParams(params.toMultiValueMap())
                }
                urlBuilder.build()
            }
            .retrieve()
            .bodyToMono(response)
            .block() ?: throw RuntimeException("Failed to fetch data")
    }


    // 확장 함수로 객체를 MultiValueMap으로 변환
    fun <T : Any> T.toMultiValueMap(): MultiValueMap<String, String> {
        val map = LinkedMultiValueMap<String, String>()
        this::class.memberProperties.forEach { prop ->
            val value = prop.getter.call(this)?.toString()
            if (value != null) {
                map.add(prop.name, value)
            }
        }
        return map
    }
}