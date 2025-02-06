package com.project.trade.coupon.domain

import com.project.trade.coupon.adapter.out.persistence.CouponTypeEntity
import com.project.trade.coupon.adapter.out.persistence.IssuedCouponEntity
import lombok.Builder
import lombok.Getter
import java.time.LocalDateTime

data class CouponType(
    val description: String,
    val issueMaxCount: Int? = 100,
    val createAt: LocalDateTime? = LocalDateTime.now()
)

fun toCouponTypeEntity(couponType: CouponType): CouponTypeEntity {
    return CouponTypeEntity(
        description = couponType.description,
        issueMaxCount = couponType.issueMaxCount,
        createdAt = couponType.createAt,
        issuedCoupons = listOf(),
    );
}

data class IssuedCoupon(
    val couponTypeId: Long,
    val couponNumber: String,
    val isUsed: Boolean? = false,
    val createdAt: LocalDateTime? = LocalDateTime.now()
)

fun toIssuedCouponEntity(issuedCoupon: IssuedCoupon, couponTypeEntity: CouponTypeEntity): IssuedCouponEntity {
    return IssuedCouponEntity(
        couponNumber = issuedCoupon.couponNumber,
        isUsed = issuedCoupon.isUsed,
        createdAt = issuedCoupon.createdAt,
        couponType = couponTypeEntity,
    );
}
