package me.dgahn.proxy.pureproxy.decorator.code

import mu.KotlinLogging

class TimeDecorator(private val component: Component) : Component {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun operation(): String {
        logger.info { "TimeDecorator 실행" }
        val startTime = System.currentTimeMillis()
        val result = component.operation()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "TimeDecorator 종료 resultTime = $resultTime ms" }
        return result
    }
}
