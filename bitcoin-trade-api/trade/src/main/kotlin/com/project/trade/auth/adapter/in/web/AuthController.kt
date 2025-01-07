package com.project.trade.auth.adapter.`in`.web

import com.project.trade.auth.application.port.`in`.GetAccessTokenUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) {
    @GetMapping("/token")
    fun getJwtToken(): ResponseEntity<String> {
        val accessToken = getAccessTokenUseCase.getAccessToken();
        return ResponseEntity.ok(accessToken)
    }
}