package me.dgahn.trace.strategy

import me.dgahn.trace.strategy.code.strategy.ContextV1
import me.dgahn.trace.strategy.code.strategy.ContextV2
import me.dgahn.trace.strategy.code.strategy.Strategy
import me.dgahn.trace.strategy.code.strategy.StrategyLogic1
import me.dgahn.trace.strategy.code.strategy.StrategyLogic2
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

    @Test
    fun strategyV1() {
        val strategyLogic1 = StrategyLogic1()
        val context1 = ContextV1(strategyLogic1)
        context1.execute()

        val strategyLogic2 = StrategyLogic2()
        val context2 = ContextV1(strategyLogic2)
        context2.execute()
    }

    @Test
    fun strategyV2() {
        val strategyLogic1 = Strategy { logger.info { "비즈니스 로직1 실행" } }
        val context1 = ContextV1(strategyLogic1)
        context1.execute()
        val strategyLogic2 = Strategy { logger.info { "비즈니스 로직2 실행" } }
        val context2 = ContextV1(strategyLogic2)
        context2.execute()
    }

    @Test
    fun strategyV3() {
        val context = ContextV2()
        context.execute(StrategyLogic1())
        context.execute(StrategyLogic2())
    }

    @Test
    fun strategyV4() {
        val context = ContextV2()
        context.execute { logger.info { "비즈니스 로직1 실행" } }
        context.execute { logger.info { "비즈니스 로직2 실행" } }
    }
}
