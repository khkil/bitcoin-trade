package com.project.trade

import com.project.trade.coupon.adapter.out.persistence.CouponTypeRepository
import com.project.trade.coupon.adapter.out.persistence.IssuedCouponRepository
import com.project.trade.coupon.application.port.`in`.IssueCouponUseCase
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.List
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


@SpringBootTest
@ActiveProfiles("security")
class BitcoinTradeApplicationTests @Autowired constructor(
    private val couponTypeRepository: CouponTypeRepository,
    private val issuedCouponRepository: IssuedCouponRepository,
    private val issueCouponUseCase: IssueCouponUseCase
) {

    @Test
    @Transactional
    fun 발행쿠폰_갯수_테스트() {
        val couponTypeId = 1L
        val issuedCount = 10L

        val numThreads = 100
        val executorService: ExecutorService = Executors.newFixedThreadPool(numThreads)
        val doneSignal = CountDownLatch(numThreads)

        /*for (i in 0 until issuedCount) {
            issueCouponUseCase.issueCoupon(couponTypeId)
        }*/
        for (i in 0..<numThreads) {
            executorService.submit {
                issueCouponUseCase.issueCoupon(couponTypeId)
//                doneSignal.countDown()
            }
        }

//        doneSignal.await()
        executorService.shutdown()
        println(issuedCouponRepository.count())

        assert(issuedCouponRepository.count() == issuedCount)
    }
}
