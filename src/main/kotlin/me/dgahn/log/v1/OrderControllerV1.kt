package me.dgahn.log.v1

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.hellotrace.HelloTraceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // ResponseBody + Controller
class OrderControllerV1(
    private val orderServiceV0: OrderServiceV1,
    private val trace: HelloTraceV1
) {

    @GetMapping("/v1/request")
    fun request(itemId: String): String {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderControllerV1.request()")
            orderServiceV0.orderItem(itemId)
            trace.end(status)
            return "ok"
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
