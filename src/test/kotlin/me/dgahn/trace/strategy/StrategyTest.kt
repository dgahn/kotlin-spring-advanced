package me.dgahn.trace.strategy

import mu.KotlinLogging
import org.junit.jupiter.api.Test

class StrategyTest {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    @Test
    fun strategyMethodV0() {
        logic1()
        logic2()
    }

    private fun logic1() {
        val startTime = System.currentTimeMillis()
        logger.info { "비즈니스 로직1 실행" }
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "resultTime=$resultTime" }
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()
        logger.info { "비즈니스 로직2 실행" }
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "resultTime=$resultTime" }
    }
}
