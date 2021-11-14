package me.dgahn.trace.template.code

import mu.KotlinLogging

class SubClassLogic1 : AbstractTemplate() {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun call() {
        logger.info { "비즈니스 로직1 실행" }
    }
}
