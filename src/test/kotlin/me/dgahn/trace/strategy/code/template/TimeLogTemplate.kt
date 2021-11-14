package me.dgahn.trace.strategy.code.template

import mu.KotlinLogging

class TimeLogTemplate {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun execute(callback: Callback) {
        val startTime = System.currentTimeMillis()
        callback.call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "resultTime=$resultTime" }
    }
}
