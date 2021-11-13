package me.dgahn.trace.hellotrace

import org.junit.jupiter.api.Test

class HelloTraceV2Test {

    @Test
    fun begin_end() {
        val trace = HelloTraceV2()
        val status1 = trace.begin("hello")
        val status2 = trace.beginSync(status1.traceId, "hello")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun begin_exception() {
        val trace = HelloTraceV2()
        val status1 = trace.begin("hello")
        val status2 = trace.beginSync(status1.traceId, "hello")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }
}
