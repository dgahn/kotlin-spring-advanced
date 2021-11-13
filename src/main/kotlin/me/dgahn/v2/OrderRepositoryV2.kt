package me.dgahn.v2

import me.dgahn.trace.TraceId
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.hellotrace.HelloTraceV2
import mu.KotlinLogging
import org.springframework.stereotype.Repository

private const val SLEEP = 1_000L

val logger = KotlinLogging.logger { }

@Repository
class OrderRepositoryV2(private val trace: HelloTraceV2) {

    fun save(traceId: TraceId, itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.beginSync(traceId, "OrderRepositoryV2.save()")
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
