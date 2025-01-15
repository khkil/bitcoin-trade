package com.project.trade.coupon.application.port.out

import com.project.trade.coupon.domain.IssuedCoupon

interface IssueCouponPort {
    fun issueCoupon(issuedCoupons: List<IssuedCoupon>)
    fun generateCouponNumber(): String
}