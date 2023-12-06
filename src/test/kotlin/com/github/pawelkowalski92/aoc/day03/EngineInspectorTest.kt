package com.github.pawelkowalski92.aoc.day03

import com.github.pawelkowalski92.aoc.day03.engine.EngineFactory
import com.github.pawelkowalski92.aoc.day03.engine.extractors.NumericPartExtractor
import com.github.pawelkowalski92.aoc.day03.engine.locators.NumericPartLocator
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class EngineInspectorTest : ShouldSpec({

    should("summarize all valid parts on schematics") {
        // given
        val engineFactory = EngineFactory()
        val engineInspector = EngineInspector(
            partExtractor = NumericPartExtractor(
                numericPartLocator = NumericPartLocator()
            )
        )

        // and
        val schematics = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
        )

        // when
        val result = engineFactory.createEngine(schematics)
            .let(engineInspector::inspectEngine)

        // then
        result shouldBe 4361
    }

})