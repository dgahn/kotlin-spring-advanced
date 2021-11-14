package me.dgahn.v5

import me.dgahn.trace.callback.TraceTemplate
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(
    private val orderRepositoryV0: OrderRepositoryV5,
    private val trace: LogTrace
) {
    private val template = TraceTemplate(trace)

    fun orderItem(itemId: String) {
        template.execute("OrderServiceV4.orderItem()") {
            orderRepositoryV0.save(itemId)
        }
    }
}
