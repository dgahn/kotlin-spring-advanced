package me.dgahn.proxy.config.v1.concreteproxy

import me.dgahn.proxy.app.v2.OrderControllerV2
import me.dgahn.proxy.app.v2.OrderServiceV2
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

class OrderControllerConcreteProxy(
    orderService: OrderServiceV2,
    private val target: OrderControllerV2,
    private val logTrace: LogTrace
) : OrderControllerV2(orderService) {
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
