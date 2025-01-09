package com.project.trade.common.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies.LowerCamelCaseStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean
    fun objectMapperCustom(): ObjectMapper {
        return ObjectMapper().apply {
            propertyNamingStrategy = LowerCamelCaseStrategy.INSTANCE
        }
    }
}