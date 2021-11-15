package me.dgahn.proxy.pureproxy.proxy.code

import mu.KotlinLogging

class CacheProxy(private val target: Subject) : Subject {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    private var cacheValue: String = ""

    override fun operation(): String {
        logger.info { "프록시 호출" }
        if (cacheValue.isBlank()) {
            cacheValue = target.operation()
        }
        return cacheValue
    }
}
