package me.dgahn.proxy.config.v1

import me.dgahn.proxy.app.v1.OrderControllerV1Impl
import me.dgahn.proxy.app.v1.OrderRepositoryV1Impl
import me.dgahn.proxy.app.v1.OrderServiceV1Impl
import me.dgahn.proxy.config.v1.interfaceproxy.OrderControllerInterfaceProxy
import me.dgahn.proxy.config.v1.interfaceproxy.OrderRepositoryInterfaceProxy
import me.dgahn.proxy.config.v1.interfaceproxy.OrderServiceInterfaceProxy
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InterfaceProxyConfig {

    @Bean
    fun orderController(logTrace: LogTrace) =
        OrderControllerInterfaceProxy(OrderControllerV1Impl(orderService(logTrace)), logTrace)

    @Bean
    fun orderService(logTrace: LogTrace) =
        OrderServiceInterfaceProxy(OrderServiceV1Impl(orderRepository(logTrace)), logTrace)

    @Bean
    fun orderRepository(logTrace: LogTrace) = OrderRepositoryInterfaceProxy(OrderRepositoryV1Impl(), logTrace)
}
