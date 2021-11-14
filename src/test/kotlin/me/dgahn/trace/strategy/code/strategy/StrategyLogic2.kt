package me.dgahn.trace.strategy.code.strategy

import mu.KotlinLogging

class StrategyLogic2 : Strategy {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun call() {
        logger.info { "비즈니스 로직 2 실행" }
    }
}
