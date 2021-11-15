package me.dgahn.proxy.pureproxy.decorator.code

import mu.KotlinLogging

class RealComponent : Component {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun operation(): String {
        logger.info { "RealComponent 실행" }
        return "data"
    }
}
