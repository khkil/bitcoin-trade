package com.project.trade.auth.adapter.out.persistence

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.project.trade.auth.application.port.out.GetAccessTokenPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

@Component
class AuthPersistenceAdapter : GetAccessTokenPort {

    @Value("\${upbit.open-api.access-key}")
    lateinit var accessKey: String

    @Value("\${upbit.open-api.secret-key}")
    lateinit var secretKey: String

    override fun getAccessToken(): String {
        val md: MessageDigest = MessageDigest.getInstance("SHA-512");

        val queryHash: String = String.format("%0128x", BigInteger(1, md.digest()))

        val algorithm: Algorithm = Algorithm.HMAC256(secretKey);
        val jwtToken: String = JWT.create()
            .withClaim("access_key", accessKey)
            .withClaim("nonce", UUID.randomUUID().toString())
            .withClaim("query_hash", queryHash)
            .withClaim("query_hash_alg", "SHA512")
            .sign(algorithm)

        return jwtToken
    }
}