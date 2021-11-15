package me.dgahn.proxy.pureproxy.proxy

import me.dgahn.proxy.pureproxy.proxy.code.ProxyPatternClient
import me.dgahn.proxy.pureproxy.proxy.code.RealSubject
import org.junit.jupiter.api.Test

class ProxyPatternTest {

    @Test
    fun noProxyTest() {
        val realSubject = RealSubject()
        val client = ProxyPatternClient(realSubject)
        client.execute()
        client.execute()
        client.execute()
    }
}
