package me.dgahn.trace

import me.dgahn.trace.logtrace.LogTrace
import me.dgahn.trace.logtrace.ThreadLocalLogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogTraceConfig {

    @Bean
    fun logTrace(): LogTrace = ThreadLocalLogTrace()
}
