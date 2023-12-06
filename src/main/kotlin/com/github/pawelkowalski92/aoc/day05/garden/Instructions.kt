package com.github.pawelkowalski92.aoc.day05.garden

data class Instructions(
    private val entries: List<InstructionsEntry>
) {

    fun findDestinationReference(sourceRef: Long): Long =
        entries.firstNotNullOfOrNull { it.findDestinationRef(sourceRef) } ?: sourceRef

    data class InstructionsEntry(
        val source: Long,
        val destination: Long,
        val range: Long
    ) {

        fun findDestinationRef(sourceRef: Long): Long? = sourceRef.takeIf(sourceRange::contains)
            ?.let { it - source + destination }

        private val sourceRange: LongRange
            get() = source..<source + range

    }

}