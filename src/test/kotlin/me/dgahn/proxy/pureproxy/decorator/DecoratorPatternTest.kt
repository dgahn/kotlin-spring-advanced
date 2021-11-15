package me.dgahn.proxy.pureproxy.decorator

import me.dgahn.proxy.pureproxy.decorator.code.DecoratorPatternClient
import me.dgahn.proxy.pureproxy.decorator.code.RealComponent
import mu.KotlinLogging
import org.junit.jupiter.api.Test

class DecoratorPatternTest {
    companion object {
        private val logger = KotlinLogging.logger {  }
    }

    @Test
    fun noDecorator() {
        val realComponent = RealComponent()
        val client = DecoratorPatternClient(realComponent)
        client.execute()
    }
}