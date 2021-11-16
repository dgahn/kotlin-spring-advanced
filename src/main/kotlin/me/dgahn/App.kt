package me.dgahn

import me.dgahn.proxy.config.v1.InterfaceProxyConfig
import me.dgahn.trace.logtrace.ThreadLocalLogTrace
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

// @Import(value = [AppV1Config::class, AppV2Config::class])
@Import(value = [InterfaceProxyConfig::class])
@SpringBootApplication(scanBasePackages = ["me.dgahn.proxy.app"])
class App {
    @Bean
    fun logTrace() = ThreadLocalLogTrace()
}

fun main(arg: Array<String>) {
    runApplication<App>(*arg)
}
