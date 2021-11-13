package me.dgahn.v2

import me.dgahn.trace.TraceId
import me.dgahn.trace.TraceStatus
import me.dgahn.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Service

@Service
class OrderServiceV2(
    private val orderRepositoryV0: OrderRepositoryV2,
    private val trace: HelloTraceV2
) {
    fun orderItem(traceId: TraceId, itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.beginSync(traceId, "OrderServiceV2.orderItem()")
            orderRepositoryV0.save(status.traceId, itemId)
            trace.end(status)
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
