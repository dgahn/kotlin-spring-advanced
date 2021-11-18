package me.dgahn.proxy.config.v1.concreteproxy

import me.dgahn.proxy.app.v2.OrderRepositoryV2
import me.dgahn.proxy.app.v2.OrderServiceV2
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

class OrderServiceConcreteProxy(
    orderRepository: OrderRepositoryV2,
    private val target: OrderServiceV2,
    private val logTrace: LogTrace
) : OrderServiceV2(orderRepository) {
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
