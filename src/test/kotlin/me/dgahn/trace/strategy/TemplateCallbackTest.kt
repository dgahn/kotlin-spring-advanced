package me.dgahn.trace.strategy

import me.dgahn.trace.strategy.code.template.TimeLogTemplate
import mu.KotlinLogging
import org.junit.jupiter.api.Test

class TemplateCallbackTest {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    fun callback() {
        val template = TimeLogTemplate()
        template.execute { logger.info { "비즈니스 로직1 실행" } }
        template.execute { logger.info { "비즈니스 로직2 실행" } }
    }
}
