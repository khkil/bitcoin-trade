package com.project.trade.coupon.adapter.out.persistence

import com.project.trade.coupon.application.port.out.CreateCouponPort
import com.project.trade.coupon.application.port.out.IssueCouponPort
import com.project.trade.coupon.domain.CouponType
import com.project.trade.coupon.domain.IssuedCoupon
import com.project.trade.coupon.domain.toCouponTypeEntity
import com.project.trade.coupon.domain.toIssuedCouponEntity
import org.springframework.stereotype.Component
import java.util.Optional
import java.util.UUID

@Component
class CouponPersistenceAdapter(
    private val issuedCouponRepository: IssuedCouponRepository,
    private val couponTypeRepository: CouponTypeRepository
) : CreateCouponPort, IssueCouponPort {
    override fun createCouponType(couponType: CouponType) {
        couponTypeRepository.save(toCouponTypeEntity(couponType))
    }

    override fun issueCoupon(issuedCoupon: IssuedCoupon) {
        val couponType: CouponTypeEntity = couponTypeRepository.findById(issuedCoupon.couponTypeId).orElseThrow { throw IllegalArgumentException("coupon type not found") }
        val issuedCouponCount = issuedCouponRepository.count()
        if (issuedCouponCount >= couponType.issueMaxCount) {
            //throw IllegalArgumentException("쿠폰발급수 초과")
        }
        issuedCouponRepository.save(toIssuedCouponEntity(issuedCoupon, couponType))
    }

    override fun generateCouponNumber(): String {
        return UUID.randomUUID().toString().replace("-", "").uppercase()
    }
}