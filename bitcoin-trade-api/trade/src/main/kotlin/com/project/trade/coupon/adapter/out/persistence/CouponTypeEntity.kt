package com.project.trade.coupon.adapter.out.persistence

import jakarta.persistence.*
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Entity
@Table(name = "COUPON_TYPE")
@Getter
data class CouponTypeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    val description: String,

    val issueMaxCount: Long,

    val createdAt: LocalDateTime?,

    @OneToMany(mappedBy = "couponType", cascade = [CascadeType.ALL])
    val issuedCoupons: List<IssuedCouponEntity>?
)


