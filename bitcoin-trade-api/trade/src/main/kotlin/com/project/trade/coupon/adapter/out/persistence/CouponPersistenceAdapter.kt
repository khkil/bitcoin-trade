package com.project.trade.coupon.adapter.out.persistence

import com.project.trade.coupon.application.port.out.CreateCouponTypePort
import com.project.trade.coupon.application.port.out.IssueCouponPort
import com.project.trade.coupon.domain.CouponType
import com.project.trade.coupon.domain.IssuedCoupon
import com.project.trade.coupon.domain.toCouponTypeEntity
import com.project.trade.coupon.domain.toIssuedCouponEntity
import java.util.UUID

class CouponPersistenceAdapter(
    private val issuedCouponRepository: IssuedCouponRepository,
    private val couponTypeRepository: CouponTypeRepository
) : CreateCouponTypePort, IssueCouponPort {
    override fun createCouponType(couponType: CouponType) {
        couponTypeRepository.save(toCouponTypeEntity(couponType))
    }

    override fun issueCoupon(issuedCoupons: List<IssuedCoupon>) {
        issuedCouponRepository.saveAll(issuedCoupons.map { toIssuedCouponEntity(it) })
    }

    override fun generateCouponNumber(): String {
        return UUID.randomUUID().toString().replace("-", "").uppercase()
    }
}