package me.dgahn.proxy.pureproxy.proxy.code

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

class RealSubject : Subject {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun operation(): String {
        logger.info { "실제 객체 호출" }
        runBlocking {
            delay(1_000L)
        }
        return "data"
    }
}
