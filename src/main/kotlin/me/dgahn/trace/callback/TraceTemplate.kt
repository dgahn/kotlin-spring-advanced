package me.dgahn.trace.callback

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace
import mu.KotlinLogging

class TraceTemplate(val trace: LogTrace) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun <T> execute(message: String, callBack: TraceCallBack<T>): T {
        var status: TraceStatus? = null
        try {
            status = trace.begin(message)
            val result: T = callBack.call()
            trace.end(status)
            return result
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
