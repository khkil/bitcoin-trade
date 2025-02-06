package com.project.trade.coupon.adapter

import com.project.trade.coupon.application.port.`in`.IssueCouponUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/coupon")
class CouponController(
    private val issuedCouponUseCase: IssueCouponUseCase
) {
    @PostMapping
    @RequestMapping("/types/{couponTypeId}/issue")
    fun issueCoupon(@PathVariable couponTypeId: Long): ResponseEntity<Any> {
        issuedCouponUseCase.issueCoupon(couponTypeId)
        return ResponseEntity.ok("test")
    }
}