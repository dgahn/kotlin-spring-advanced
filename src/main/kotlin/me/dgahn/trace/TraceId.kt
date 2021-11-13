package me.dgahn.trace

import java.util.UUID

@Suppress("MagicNumber")
data class TraceId(
    val id: String = createId(),
    val level: Int = 0
) {
    companion object {
        private fun createId() = UUID.randomUUID().toString().substring(0, 8)
    }

    private fun createNextId() = this.copy(level = this.level + 1)

    private fun createPreviousId() = this.copy(level = this.level - 1)

    fun isFirstLevel() = level == 0
}
