package me.dgahn.log.v5

import me.dgahn.trace.callback.TraceTemplate
import me.dgahn.trace.logtrace.LogTrace
import mu.KotlinLogging
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV5(private val trace: LogTrace) {
    companion object {
        private const val SLEEP = 1_000L
        val logger = KotlinLogging.logger { }
    }
    private val template = TraceTemplate(trace)

    fun save(itemId: String) {
        template.execute("OrderRepositoryV4.save()") {
            if (itemId == "ex") {
                throw IllegalStateException("예외 발생!")
            }
            sleep(SLEEP)
        }
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            logger.error { e.stackTraceToString() }
        }
    }
}
