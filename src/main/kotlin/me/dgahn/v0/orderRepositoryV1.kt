package me.dgahn.v0

import mu.KotlinLogging
import org.springframework.stereotype.Repository

private const val SLEEP = 1_000L

val logger = KotlinLogging.logger { }

@Repository
class OrderRepositoryV0 {

    fun save(itemId: String) {
        if (itemId == "ex") {
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
