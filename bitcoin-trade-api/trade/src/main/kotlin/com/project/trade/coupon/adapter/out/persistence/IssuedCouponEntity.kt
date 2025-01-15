package com.project.trade.coupon.adapter.out.persistence

import jakarta.persistence.*
import lombok.Getter
import org.hibernate.boot.spi.AccessType
import java.time.LocalDateTime

@Entity
@Table(name = "ISSUED_COUPON")
@Getter
data class IssuedCouponEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    val couponNumber: String,

    val isUsed: Boolean?,

    val createdAt: LocalDateTime?
)