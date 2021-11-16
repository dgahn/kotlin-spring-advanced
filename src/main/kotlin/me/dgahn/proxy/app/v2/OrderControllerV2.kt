package me.dgahn.proxy.app.v2

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@RequestMapping("/orders")
@ResponseBody
@Suppress("FunctionOnlyReturningConstant")
class OrderControllerV2(private val orderService: OrderServiceV2) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    @GetMapping("/v2/request")
    fun request(itemId: String): String {
        orderService.orderItem(itemId)
        return "ok"
    }

    @GetMapping("/v2/no-log")
    fun noLog(): String = "ok"
}
