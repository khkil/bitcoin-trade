package com.project.trade.coupon.application.port.out

import com.project.trade.coupon.domain.CouponType

interface CreateCouponPort {
    fun createCouponType(couponType: CouponType)
}