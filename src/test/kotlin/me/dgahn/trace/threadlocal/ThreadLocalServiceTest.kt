package me.dgahn.trace.threadlocal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.dgahn.trace.threadlocal.code.ThreadLocalService
import mu.KotlinLogging
import org.junit.jupiter.api.Test

class ThreadLocalServiceTest {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    val threadLocalService = ThreadLocalService()

    @Test
    fun field() {
        runBlocking {
            CoroutineScope(Dispatchers.Default).launch {
                threadLocalService.logic("userA")
            }
//            delay(2000)
            CoroutineScope(Dispatchers.Default).launch {
                threadLocalService.logic("userB")
            }
            delay(2000)
        }
    }
}
