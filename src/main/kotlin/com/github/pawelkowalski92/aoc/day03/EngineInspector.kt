package com.github.pawelkowalski92.aoc.day03

import com.github.pawelkowalski92.aoc.day03.engine.Engine
import com.github.pawelkowalski92.aoc.day03.engine.EnginePart
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor

class EngineInspector(
    private val partExtractor: EnginePartExtractor<EnginePart>
) {

    fun inspectEngine(engine: Engine): Int = engine.findAllParts(partExtractor).sumOf(EnginePart::value)

}