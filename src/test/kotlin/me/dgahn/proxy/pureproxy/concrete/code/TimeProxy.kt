package me.dgahn.proxy.pureproxy.concrete.code

import mu.KotlinLogging

class TimeProxy(private val concreteLogic: ConcreteLogic) : ConcreteLogic() {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun operation(): String {
        logger.info { "TimeProxy 실행" }
        val startTime = System.currentTimeMillis()
        val result = concreteLogic.operation()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "TimeProxy 종료 resultTime = $resultTime ms" }
        return result
    }
}
