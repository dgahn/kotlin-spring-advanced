package me.dgahn.v4

import me.dgahn.trace.logtrace.LogTrace
import me.dgahn.trace.template.AbstractTemplate
import mu.KotlinLogging
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV4(private val trace: LogTrace) {
    companion object {
        private const val SLEEP = 1_000L
        val logger = KotlinLogging.logger { }
    }

    fun save(itemId: String) {
        val template = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                if (itemId == "ex") {
                    throw IllegalStateException("예외 발생!")
                }
                sleep(SLEEP)
                return
            }
        }
        template.execute("OrderRepositoryV4.save()")
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            logger.error { e.stackTraceToString() }
        }
    }
}
