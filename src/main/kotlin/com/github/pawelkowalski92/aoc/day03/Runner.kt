package com.github.pawelkowalski92.aoc.day03

import com.github.pawelkowalski92.aoc.day03.engine.EngineFactory
import com.github.pawelkowalski92.aoc.day03.engine.extractors.GearExtractor
import com.github.pawelkowalski92.aoc.day03.engine.extractors.NumericPartExtractor
import com.github.pawelkowalski92.aoc.day03.engine.locators.GearPartLocator
import com.github.pawelkowalski92.aoc.day03.engine.locators.NumericPartLocator
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val engineFactory = EngineFactory()
            val engineInspector = EngineInspector(
                partExtractor = NumericPartExtractor(
                    numericPartLocator = NumericPartLocator()
                )
            )

            val result = getResource("inputs/day-3.txt").readLines()
                .let(engineFactory::createEngine)
                .let(engineInspector::inspectEngine)
            println(result)
        }

    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val engineFactory = EngineFactory()
            val gearInspector = GearInspector(
                partExtractor = GearExtractor(
                    gearPartLocator = GearPartLocator(),
                    numericPartLocator = NumericPartLocator()
                )
            )

            val result = getResource("inputs/day-3.txt").readLines()
                .let(engineFactory::createEngine)
                .let(gearInspector::inspectGears)
            println(result)
        }

    }

}