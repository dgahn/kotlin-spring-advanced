package me.dgahn.proxy.pureproxy.proxy

import me.dgahn.proxy.pureproxy.proxy.code.CacheProxy
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

    @Test
    fun cacheProxyTest() {
        val realSubject = RealSubject()
        val cacheProxy = CacheProxy(realSubject)
        val proxyPatternClient = ProxyPatternClient(cacheProxy)
        proxyPatternClient.execute()
        proxyPatternClient.execute()
        proxyPatternClient.execute()
    }
}
