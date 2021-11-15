package me.dgahn.proxy.pureproxy.decorator.code

import mu.KotlinLogging

class DecoratorPatternClient(private val component: Component) {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun execute() {
        val result = component.operation()
        logger.info { "result:$result" }
    }

}