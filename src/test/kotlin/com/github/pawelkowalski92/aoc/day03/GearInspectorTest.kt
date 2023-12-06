package com.github.pawelkowalski92.aoc.day03

import com.github.pawelkowalski92.aoc.day03.engine.EngineFactory
import com.github.pawelkowalski92.aoc.day03.engine.extractors.GearExtractor
import com.github.pawelkowalski92.aoc.day03.engine.locators.GearPartLocator
import com.github.pawelkowalski92.aoc.day03.engine.locators.NumericPartLocator
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GearInspectorTest : ShouldSpec({

    should("summarize all valid gear ratios on schematics") {
        // given
        val engineFactory = EngineFactory()
        val gearInspector = GearInspector(
            partExtractor = GearExtractor(
                gearPartLocator = GearPartLocator(),
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
            .let(gearInspector::inspectGears)

        // then
        result shouldBe 467835
    }

})