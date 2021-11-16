package me.dgahn.proxy.pureproxy.concrete

import me.dgahn.proxy.pureproxy.concrete.code.ConcreteClient
import me.dgahn.proxy.pureproxy.concrete.code.ConcreteLogic
import me.dgahn.proxy.pureproxy.concrete.code.TimeProxy
import org.junit.jupiter.api.Test

class ConcreteProxyTest {

    @Test
    fun noProxy() {
        val concreteLogic = ConcreteLogic()
        val concreteClient = ConcreteClient(concreteLogic)
        concreteClient.execute()
    }

    @Test
    fun addProxy() {
        val concreteLogic = ConcreteLogic()
        val timeProxy = TimeProxy(concreteLogic)
        val concreteClient = ConcreteClient(timeProxy)
        concreteClient.execute()
    }
}
