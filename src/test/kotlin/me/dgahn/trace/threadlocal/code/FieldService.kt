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
        logger.info { "저장 name=$name -> nameStore=$nameStore" }
        nameStore = name
        sleep(1_000)
        logger.info { "조회 nameStore=$nameStore" }
        return nameStore
    }

    private fun sleep(millis: Long) {
        runBlocking {
            delay(millis)
        }
    }
}
