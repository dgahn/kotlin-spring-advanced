package me.dgahn.trace.strategy.code.strategy

import mu.KotlinLogging

class StrategyLogic1 : Strategy {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun call() {
        logger.info { "비즈니스 로직 1 실행" }
    }
}
