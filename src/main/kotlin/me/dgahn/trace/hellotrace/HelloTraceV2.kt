package me.dgahn.trace.hellotrace

import me.dgahn.trace.TraceId
import me.dgahn.trace.TraceStatus
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class HelloTraceV2 {

    companion object {
        private val logger = KotlinLogging.logger { }
        private const val START_PREFIX = "-->"
        private const val COMPLETE_PREFIX = "<--"
        private const val EX_PREFIX = "<X-"
    }

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startTimeMs = System.currentTimeMillis()
        logger.info(
            "[{}] {}{}", traceId.id,
            addSpace(
                START_PREFIX,
                traceId.level
            ),
            message
        )
        return TraceStatus(traceId, startTimeMs, message)
    }

    fun beginSync(beforeTraceId: TraceId, message: String): TraceStatus {
        val nextId = beforeTraceId.createNextId()
        val startTimeMs = System.currentTimeMillis()
        logger.info(
            "[{}] {}{}", nextId.id,
            addSpace(
                START_PREFIX,
                nextId.level
            ),
            message
        )
        return TraceStatus(nextId, startTimeMs, message)
    }

    fun end(status: TraceStatus) {
        complete(status)
    }

    fun exception(status: TraceStatus, e: Exception?) {
        complete(status, e)
    }

    private fun complete(status: TraceStatus, e: java.lang.Exception? = null) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs: Long = stopTimeMs - status.startTimeMs
        val (id, level) = status.traceId
        if (e == null) {
            logger.info(
                "[{}] {}{} time={}ms", id,
                addSpace(COMPLETE_PREFIX, level), status,
                resultTimeMs
            )
        } else {
            logger.info(
                "[{}] {}{} time={}ms ex={}", id,
                addSpace(EX_PREFIX, level), status.message, resultTimeMs,
                e.toString()
            )
        }
    }

    private fun addSpace(prefix: String, level: Int): String? {
        val sb = StringBuilder()
        for (i in 0 until level) {
            sb.append(if (i == level - 1) "|$prefix" else "|   ")
        }
        return sb.toString()
    }
}
