package com.github.pawelkowalski92.aoc.day03.engine

import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor.SchematicsContext

class Engine(private val schematics: List<SchematicsPart>) {

    fun <T> findAllParts(partExtractor: EnginePartExtractor<T>): List<T> = schematics.indices
        .map { ix ->
            SchematicsContext(
                current = schematics[ix],
                previous = (ix - 1).takeUnless { it < 0 }?.let(schematics::get),
                next = (ix + 1).takeIf { it < schematics.size }?.let(schematics::get)
            )
        }.flatMap(partExtractor::extractPart)

}