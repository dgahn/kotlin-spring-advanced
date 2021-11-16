package me.dgahn.proxy.pureproxy.concrete

import me.dgahn.proxy.pureproxy.concrete.code.ConcreteClient
import me.dgahn.proxy.pureproxy.concrete.code.ConcreteLogic
import org.junit.jupiter.api.Test

class ConcreteProxyTest {

    @Test
    fun noProxy() {
        val concreteLogic = ConcreteLogic()
        val concreteClient = ConcreteClient(concreteLogic)
        concreteClient.execute()
    }

}