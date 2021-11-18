package me.dgahn.proxy.config.v1

import me.dgahn.proxy.app.v2.OrderControllerV2
import me.dgahn.proxy.app.v2.OrderRepositoryV2
import me.dgahn.proxy.app.v2.OrderServiceV2
import me.dgahn.proxy.config.v1.concreteproxy.OrderControllerConcreteProxy
import me.dgahn.proxy.config.v1.concreteproxy.OrderRepositoryConcreteProxy
import me.dgahn.proxy.config.v1.concreteproxy.OrderServiceConcreteProxy
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConcreteProxyConfig {

    @Bean
    fun orderRepositoryV2(logTrace: LogTrace): OrderRepositoryConcreteProxy {
        val orderRepository = OrderRepositoryV2()
        return OrderRepositoryConcreteProxy(orderRepository, logTrace)
    }

    @Bean
    fun orderServiceV2(logTrace: LogTrace): OrderServiceConcreteProxy {
        val orderRepository = orderRepositoryV2(logTrace)
        val orderService = OrderServiceV2(orderRepository)
        return OrderServiceConcreteProxy(orderRepository, orderService, logTrace)
    }

    @Bean
    fun orderController(logTrace: LogTrace): OrderControllerConcreteProxy {
        val orderService = orderServiceV2(logTrace)
        val orderController = OrderControllerV2(orderService)
        return OrderControllerConcreteProxy(orderService, orderController, logTrace)
    }
}
