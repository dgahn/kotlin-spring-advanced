package me.dgahn.trace

import me.dgahn.trace.logtrace.FieldLogTrace
import me.dgahn.trace.logtrace.LogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogTraceConfig {

    @Bean
    fun logTrace(): LogTrace = FieldLogTrace()
}
