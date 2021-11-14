package me.dgahn.trace.strategy.code.strategy

import mu.KotlinLogging

class ContextV1(
    private val strategy: Strategy
) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun execute() {
        val startTime = System.currentTimeMillis()
        strategy.call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "resultTime=$resultTime" }
    }
}
