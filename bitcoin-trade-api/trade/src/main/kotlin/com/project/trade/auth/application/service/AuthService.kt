package com.project.trade.auth.application.service

import com.project.trade.auth.application.port.`in`.GetAccessTokenUseCase
import com.project.trade.auth.application.port.out.GetAccessTokenPort
import org.springframework.stereotype.Service

@Service
class AuthService(private val getAccessTokenPort: GetAccessTokenPort) : GetAccessTokenUseCase {
    override fun getAccessToken(): String {
        return getAccessTokenPort.getAccessToken()
    }
}