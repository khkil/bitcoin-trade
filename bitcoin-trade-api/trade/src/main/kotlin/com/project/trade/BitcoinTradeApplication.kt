package com.project.trade

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
class BitcoinTradeApplication

fun main(args: Array<String>) {
	runApplication<BitcoinTradeApplication>(*args)
}
