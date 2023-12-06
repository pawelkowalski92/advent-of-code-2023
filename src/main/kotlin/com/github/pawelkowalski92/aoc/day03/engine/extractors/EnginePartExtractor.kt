package com.github.pawelkowalski92.aoc.day03.engine.extractors

import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart

fun interface EnginePartExtractor<T> {

    fun extractPart(schematicsContext: SchematicsContext): List<T>

    data class SchematicsContext(
        val current: SchematicsPart,
        val previous: SchematicsPart?,
        val next: SchematicsPart?
    )

}