package me.dgahn.trace.threadlocal.code

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

class ThreadLocalService {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    private var nameStore: ThreadLocal<String> = ThreadLocal()

    fun logic(name: String): String {
        logger.info { "์ ์ฅ name=$name -> nameStore=${nameStore.get()}" }
        nameStore.set(name)
        sleep(1_000)
        logger.info { "์กฐํ nameStore=${nameStore.get()}" }
        return nameStore.get()
    }

    private fun sleep(millis: Long) {
        runBlocking {
            delay(millis)
        }
    }
}
