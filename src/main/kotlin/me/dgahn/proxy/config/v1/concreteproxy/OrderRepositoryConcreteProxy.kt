package me.dgahn.proxy.config.v1.concreteproxy

import me.dgahn.proxy.app.v2.OrderRepositoryV2
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace

class OrderRepositoryConcreteProxy(
    private val target: OrderRepositoryV2,
    private val logTrace: LogTrace
) : OrderRepositoryV2() {
    override fun save(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = logTrace.begin("OrderRepository.request()")
            target.save(itemId)
            logTrace.end(status)
        } catch (e: IllegalStateException) {
            logTrace.exception(status!!, e)
            throw e
        }
    }
}
