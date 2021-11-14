package me.dgahn.trace.logtrace

import me.dgahn.trace.TraceStatus

interface LogTrace {

    fun begin(message: String): TraceStatus

    fun end(status: TraceStatus)

    fun exception(status: TraceStatus, e: Exception? = null)
}
