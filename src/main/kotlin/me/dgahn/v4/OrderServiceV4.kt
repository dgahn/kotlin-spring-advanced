package me.dgahn.v4

import me.dgahn.trace.logtrace.LogTrace
import me.dgahn.trace.template.AbstractTemplate
import org.springframework.stereotype.Service

@Service
class OrderServiceV4(
    private val orderRepositoryV0: OrderRepositoryV4,
    private val trace: LogTrace
) {
    fun orderItem(itemId: String) {
        val template = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                orderRepositoryV0.save(itemId)
                return
            }
        }
        template.execute("OrderServiceV4.orderItem()")
    }
}
