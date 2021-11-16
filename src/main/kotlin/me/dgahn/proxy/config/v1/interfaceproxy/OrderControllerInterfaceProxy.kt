package me.dgahn.proxy.config.v1.interfaceproxy

import me.dgahn.proxy.app.v1.OrderControllerV1
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

class OrderControllerInterfaceProxy(
    private val target: OrderControllerV1,
    private val logTrace: LogTrace
) : OrderControllerV1 {
    override fun request(itemId: String): String {
        var status: TraceStatus? = null
        try {
            status = logTrace.begin("OrderController.request()")
            val result = target.request(itemId)
            logTrace.end(status)
            return result
        } catch (e: IllegalStateException) {
            logTrace.exception(status!!, e)
            throw e
        }
    }

    override fun noLog(): String = target.noLog()
}
