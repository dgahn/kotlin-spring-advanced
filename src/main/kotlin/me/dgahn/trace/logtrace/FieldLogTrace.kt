package me.dgahn.trace.logtrace

import me.dgahn.trace.TraceId
import me.dgahn.trace.TraceStatus
import mu.KotlinLogging

class FieldLogTrace : LogTrace {
    companion object {
        private val logger = KotlinLogging.logger { }
        private const val START_PREFIX = "-->"
        private const val COMPLETE_PREFIX = "<--"
        private const val EX_PREFIX = "<X-"
    }

    var traceIdHolder: TraceId? = null

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId = traceIdHolder!!
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

    private fun syncTraceId() {
        traceIdHolder = if (traceIdHolder == null) {
            TraceId()
        } else {
            traceIdHolder!!.createNextId()
        }
    }

    override fun end(status: TraceStatus) {
        complete(status)
    }

    override fun exception(status: TraceStatus, e: Exception?) {
        complete(status, e)
    }

    private fun complete(status: TraceStatus, e: Exception? = null) {
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

        releaseTraceId()
    }

    private fun releaseTraceId() {
        traceIdHolder = if (traceIdHolder!!.isFirstLevel()) {
            null
        } else {
            traceIdHolder!!.createPreviousId()
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
