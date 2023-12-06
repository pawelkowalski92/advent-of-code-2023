package com.github.pawelkowalski92.aoc.day03

import com.github.pawelkowalski92.aoc.day03.engine.Engine
import com.github.pawelkowalski92.aoc.day03.engine.Gear
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor

class GearInspector(
    private val partExtractor: EnginePartExtractor<Gear>
) {

    fun inspectGears(engine: Engine): Int = engine.findAllParts(partExtractor).sumOf(Gear::ratio)

}