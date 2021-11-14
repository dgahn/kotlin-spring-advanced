package me.dgahn.trace.template

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

abstract class AbstractTemplate<T>(val trace: LogTrace) {

    fun execute(message: String): T {
        var status: TraceStatus? = null
        try {
            status = trace.begin(message)
            val result: T = call()
            trace.end(status)
            return result
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }

    protected abstract fun call(): T
}
