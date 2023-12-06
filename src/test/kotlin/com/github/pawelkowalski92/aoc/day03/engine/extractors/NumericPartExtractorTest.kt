package com.github.pawelkowalski92.aoc.day03.engine.extractors

import com.github.pawelkowalski92.aoc.day03.engine.EnginePart
import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor.SchematicsContext
import com.github.pawelkowalski92.aoc.day03.engine.locators.PartLocator
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumericPartExtractorTest : ShouldSpec({

    should("extract numeric parts from engine") {
        // given
        val numericPartLocator = PartLocator { schematics ->
            listOf(
                PartLocation(schematics, 1 .. 3),
                PartLocation(schematics, 5 .. 7)
            )
        }
        val numericPartExtractor = NumericPartExtractor(
            numericPartLocator = numericPartLocator
        )

        // and
        val context = SchematicsContext(
            previous = null,
            current = SchematicsPart(".100.500"),
            next = SchematicsPart("*200.400")
        )

        // when
        val result = numericPartExtractor.extractPart(context)

        // then
        result shouldBe listOf(
            EnginePart(100)
        )
    }

})