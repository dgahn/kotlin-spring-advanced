package me.dgahn.log.v1

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.hellotrace.HelloTraceV1
import mu.KotlinLogging
import org.springframework.stereotype.Repository

private const val SLEEP = 1_000L

val logger = KotlinLogging.logger { }

@Repository
class OrderRepositoryV1(private val trace: HelloTraceV1) {

    fun save(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderRepositoryV1.save()")
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
