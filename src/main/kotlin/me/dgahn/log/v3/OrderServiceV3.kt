package me.dgahn.log.v3

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV3(
    private val orderRepositoryV0: OrderRepositoryV3,
    private val trace: LogTrace
) {
    fun orderItem(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderServiceV3.orderItem()")
            orderRepositoryV0.save(itemId)
            trace.end(status)
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
