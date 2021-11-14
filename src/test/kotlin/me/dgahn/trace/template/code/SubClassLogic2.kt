package me.dgahn.trace.template.code

import mu.KotlinLogging

class SubClassLogic2 : AbstractTemplate() {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    override fun call() {
        logger.info { "비즈니스 로직2 실행" }
    }
}
