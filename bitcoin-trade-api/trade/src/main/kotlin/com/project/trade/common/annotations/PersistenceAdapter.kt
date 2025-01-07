package com.project.trade.common.annotations

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.FUNCTION) // 어노테이션 적용 대상 (함수)
@Retention(AnnotationRetention.RUNTIME) // 런타임 시점에 유지
annotation class PersistenceAdapter(
    @get:AliasFor(annotation = Component::class) // Component의 value 속성과 매핑
    val name: String = ""
)