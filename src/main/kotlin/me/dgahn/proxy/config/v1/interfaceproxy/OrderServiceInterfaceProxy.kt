package me.dgahn.proxy.config.v1.interfaceproxy

import me.dgahn.proxy.app.v1.OrderServiceV1
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

class OrderServiceInterfaceProxy(
    private val target: OrderServiceV1,
    private val logTrace: LogTrace
) : OrderServiceV1 {
    override fun orderItem(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = logTrace.begin("OrderService.orderItem()")
            target.orderItem(itemId)
            logTrace.end(status)
        } catch (e: IllegalStateException) {
            logTrace.exception(status!!, e)
            throw e
        }
    }
}
