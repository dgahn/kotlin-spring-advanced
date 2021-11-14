package me.dgahn.trace.strategy.code.strategy

import mu.KotlinLogging

/**
 * 전략을 파라미터로 전달 받는 방식
 */

class ContextV2 {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun execute(strategy: Strategy) {
        val startTime = System.currentTimeMillis()
        strategy.call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "resultTime=$resultTime" }
    }
}
