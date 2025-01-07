package com.project.trade.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class UpbitWebClientConfig {

    @Bean
    fun upbitOpenApiClient() : WebClient {
        val client = WebClient.create("https://jsonplaceholder.typicode.com")

      /*  val response = client.get()
            .uri("/posts/1")
            .retrieve()
            .bodyToMono(String::class.java)
            .block() // 결과를 동기적으로 기다림

        println(response)
*/
        return client;
    }
}