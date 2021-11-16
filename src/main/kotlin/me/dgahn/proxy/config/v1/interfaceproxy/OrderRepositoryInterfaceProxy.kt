package me.dgahn.proxy.config.v1.interfaceproxy

import me.dgahn.proxy.app.v1.OrderRepositoryV1
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

class OrderRepositoryInterfaceProxy(
    private val orderRepositoryV1: OrderRepositoryV1,
    private val logTrace: LogTrace
) : OrderRepositoryV1 {
    override fun save(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = logTrace.begin("OrderRepository.request()")
            orderRepositoryV1.save(itemId)
            logTrace.end(status)
        } catch (e: IllegalStateException) {
            logTrace.exception(status!!, e)
            throw e
        }
    }
}
