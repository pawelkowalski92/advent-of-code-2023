package com.github.pawelkowalski92.aoc.day03.engine.locators

import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart

class NumericPartLocator: PartLocator {

    override fun locateParts(schematicsPart: SchematicsPart): List<PartLocation> = NumericPartLocationBuilder(schematicsPart)
        .let {
            mutableListOf<PartLocation>().apply {
                schematicsPart.content.forEachIndexed { ix, c ->
                    if (c.isDigit()) it.register(ix)
                    else it.takeIf { it.hasPart }?.build()?.also(::add)
                }
                it.takeIf { it.hasPart }?.build()?.also(::add)
            }
        }

    private class NumericPartLocationBuilder(
        private val schematicsPart: SchematicsPart
    ) {
        private var startIndex: Int = RESET_VALUE
        private var endIndex: Int = RESET_VALUE

        val hasPart: Boolean
            get() = startIndex != RESET_VALUE

        fun register(position: Int) {
            if (!hasPart) {
                startIndex = position
            }
            endIndex = position
        }

        fun build(): PartLocation = PartLocation(
            schematicsPart = schematicsPart,
            location = startIndex..endIndex
        ).also { reset() }

        private fun reset() {
            startIndex = RESET_VALUE
            endIndex = RESET_VALUE
        }

        companion object {
            const val RESET_VALUE = -1
        }

    }
}