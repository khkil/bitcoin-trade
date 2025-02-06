package com.project.trade.coupon.application.service

import com.project.trade.coupon.application.port.`in`.IssueCouponUseCase
import com.project.trade.coupon.application.port.out.IssueCouponPort
import com.project.trade.coupon.domain.IssuedCoupon
import org.springframework.stereotype.Component

@Component
class CouponService(
    private val issueCouponPort: IssueCouponPort
) : IssueCouponUseCase {
    override fun issueCoupon(couponTypeId: Long) {
        val couponNumber = issueCouponPort.generateCouponNumber()
        val issuedCoupon = IssuedCoupon(couponTypeId, couponNumber)

        issueCouponPort.issueCoupon(issuedCoupon)
    }
}