package me.dgahn.trace.threadlocal.code

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

class FieldService {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    private var nameStore: String = ""

    fun logic(name: String): String {
        logger.info { "์ ์ฅ name=$name -> nameStore=$nameStore" }
        nameStore = name
        sleep(1_000)
        logger.info { "์กฐํ nameStore=$nameStore" }
        return nameStore
    }

    private fun sleep(millis: Long) {
        runBlocking {
            delay(millis)
        }
    }
}
