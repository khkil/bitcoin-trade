package com.project.trade

import com.project.trade.coupon.adapter.out.persistence.CouponTypeRepository
import com.project.trade.coupon.adapter.out.persistence.IssuedCouponRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("security")
class BitcoinTradeApplicationTests @Autowired constructor(
    private val couponTypeRepository: CouponTypeRepository,
    private val couponRepository: IssuedCouponRepository
) {

	@Test
	fun 발행쿠폰_갯수_테스트() {
        val couponType = couponTypeRepository.findById(1).get()
        val issuedCount = couponType.issueMaxCount


        assert(issuedCount == 10)
	}
}
