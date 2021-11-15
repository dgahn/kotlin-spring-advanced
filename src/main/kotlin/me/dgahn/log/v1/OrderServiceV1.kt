package me.dgahn.log.v1

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Service

@Service
class OrderServiceV1(
    private val orderRepositoryV0: OrderRepositoryV1,
    private val trace: HelloTraceV1
) {
    fun orderItem(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderServiceV1.orderItem()")
            orderRepositoryV0.save(itemId)
            trace.end(status)
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
