package me.dgahn.log.v3

import me.dgahn.trace.TraceStatus
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // ResponseBody + Controller
class OrderControllerV3(
    private val orderServiceV0: OrderServiceV3,
    private val trace: LogTrace
) {

    @GetMapping("/v3/request")
    fun request(itemId: String): String {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderControllerV2.request()")
            orderServiceV0.orderItem(itemId)
            trace.end(status)
            return "ok"
        } catch (e: IllegalStateException) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
