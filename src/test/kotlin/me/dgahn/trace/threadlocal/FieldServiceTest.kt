package me.dgahn.trace.threadlocal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.dgahn.trace.threadlocal.code.FieldService
import mu.KotlinLogging
import org.junit.jupiter.api.Test

class FieldServiceTest {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    val fieldService = FieldService()

    @Test
    fun field() {
        runBlocking {
            CoroutineScope(Dispatchers.Default).launch {
                fieldService.logic("userA")
            }
//            delay(2000)
            CoroutineScope(Dispatchers.Default).launch {
                fieldService.logic("userB")
            }
            delay(2000)
        }
    }
}
