package me.dgahn.trace.template.code

import mu.KotlinLogging

abstract class AbstractTemplate {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun execute() {
        val startTime = System.currentTimeMillis()
        call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logger.info { "resultTime=$resultTime" }
    }

    abstract fun call()
}
