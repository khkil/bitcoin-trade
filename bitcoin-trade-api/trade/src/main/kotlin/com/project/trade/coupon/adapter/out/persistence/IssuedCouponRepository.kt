package com.project.trade.coupon.adapter.out.persistence

import com.project.trade.coupon.domain.CouponType
import org.springframework.data.jpa.repository.JpaRepository

interface IssuedCouponRepository : JpaRepository<IssuedCouponEntity, Long> {
}