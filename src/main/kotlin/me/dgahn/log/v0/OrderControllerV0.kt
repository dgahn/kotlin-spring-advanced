package me.dgahn.log.v0

import me.dgahn.log.v1.OrderServiceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // ResponseBody + Controller
class OrderControllerV0(private val orderServiceV0: OrderServiceV1) {

    @GetMapping("/v0/request")
    fun request(itemId: String): String {
        orderServiceV0.orderItem(itemId)
        return "ok"
    }
}
