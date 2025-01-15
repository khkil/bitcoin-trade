package com.project.trade.coupon.application.port.out

import com.project.trade.coupon.adapter.out.persistence.CouponTypeEntity
import com.project.trade.coupon.domain.CouponType

interface CreateCouponTypePort {
    fun createCouponType(couponType: CouponType)
}