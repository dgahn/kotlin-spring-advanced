package me.dgahn.proxy.app.v3

import mu.KotlinLogging
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV3 {
    companion object {
        private val logger = KotlinLogging.logger { }
        private const val SLEEP = 1_000L
    }

    fun save(itemId: String) {
        if (itemId == "eq") {
            throw IllegalStateException("예외 발생!")
        }
        sleep(SLEEP)
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            logger.error { e.stackTraceToString() }
        }
    }
}
