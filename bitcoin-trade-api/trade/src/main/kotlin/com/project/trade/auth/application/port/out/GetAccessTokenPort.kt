package com.project.trade.auth.application.port.out

interface GetAccessTokenPort {
    fun getAccessToken(): String
}