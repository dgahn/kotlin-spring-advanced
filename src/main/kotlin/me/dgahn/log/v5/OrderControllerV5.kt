package me.dgahn.log.v5

import me.dgahn.trace.callback.TraceTemplate
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // ResponseBody + Controller
class OrderControllerV5(
    private val orderServiceV0: OrderServiceV5,
    private val trace: LogTrace
) {
    private val template = TraceTemplate(trace)

    @GetMapping("/v5/request")
    fun request(itemId: String): String = template.execute("OrderController.request()") {
        orderServiceV0.orderItem(itemId)
        "ok"
    }
}
