package me.dgahn.v4

import me.dgahn.trace.logtrace.LogTrace
import me.dgahn.trace.template.AbstractTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // ResponseBody + Controller
class OrderControllerV4(
    private val orderServiceV0: OrderServiceV4,
    private val trace: LogTrace
) {

    @GetMapping("/v4/request")
    fun request(itemId: String): String {
        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): String {
                orderServiceV0.orderItem(itemId)
                return "ok"
            }
        }
        return template.execute("OrderController.request()")
    }
}
