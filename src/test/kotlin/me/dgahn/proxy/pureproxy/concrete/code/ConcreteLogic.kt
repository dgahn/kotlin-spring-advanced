package me.dgahn.proxy.pureproxy.concrete.code

import mu.KotlinLogging

open class ConcreteLogic {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    open fun operation(): String {
        logger.info { "ConcreteLogic 실행" }
        return "data"
    }
}
