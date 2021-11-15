package me.dgahn.app.v3

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders")
@RestController
@Suppress("FunctionOnlyReturningConstant")
class OrderControllerV3(private val orderService: OrderServiceV3) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    @GetMapping("/v3/request")
    fun request(itemId: String): String {
        orderService.orderItem(itemId)
        return "ok"
    }

    @GetMapping("/v3/no-log")
    fun noLog(): String = "ok"
}
