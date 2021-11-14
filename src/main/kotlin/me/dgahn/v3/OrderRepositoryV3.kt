package me.dgahn.v3

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace
import mu.KotlinLogging
import org.springframework.stereotype.Repository

private const val SLEEP = 1_000L

val logger = KotlinLogging.logger { }

@Repository
class OrderRepositoryV3(private val trace: LogTrace) {

    fun save(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderRepositoryV2.save()")
            if (itemId == "ex") {
                throw IllegalStateException("예외 발생!")
            }
            sleep(SLEEP)
            trace.end(status)
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
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
