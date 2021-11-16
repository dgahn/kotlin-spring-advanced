package me.dgahn.proxy.pureproxy.concrete.code

import mu.KotlinLogging

class ConcreteLogic {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun operation(): String {
        logger.info { "ConcreteLogic 실행" }
        return "data"
    }
}
