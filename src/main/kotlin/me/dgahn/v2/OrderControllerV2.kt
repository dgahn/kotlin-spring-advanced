package me.dgahn.v2

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.hellotrace.HelloTraceV2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // ResponseBody + Controller
class OrderControllerV2(
    private val orderServiceV0: OrderServiceV2,
    private val trace: HelloTraceV2
) {

    @GetMapping("/v2/request")
    fun request(itemId: String): String {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderControllerV2.request()")
            orderServiceV0.orderItem(status.traceId, itemId)
            trace.end(status)
            return "ok"
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}