package com.github.pawelkowalski92.aoc.day03.engine.extractors

import com.github.pawelkowalski92.aoc.day03.engine.EnginePart
import com.github.pawelkowalski92.aoc.day03.engine.Gear
import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor.SchematicsContext
import com.github.pawelkowalski92.aoc.day03.engine.locators.PartLocator
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GearExtractorTest : ShouldSpec({

    should("extract gears from engine") {
        // given
        val gearPartLocator = PartLocator { schematics ->
            listOf(
                PartLocation(schematics, 0)
            )
        }
        val numericPartLocator = PartLocator { schematics ->
            listOf(
                PartLocation(schematics, 1 .. 3),
                PartLocation(schematics, 5 .. 7)
            )
        }
        val gearExtractor = GearExtractor(
            gearPartLocator = gearPartLocator,
            numericPartLocator = numericPartLocator
        )

        // and
        val context = SchematicsContext(
            previous = null,
            current = SchematicsPart(".100.500"),
            next = SchematicsPart("*200.400")
        )

        // when
        val result = gearExtractor.extractPart(context)

        // then
        result shouldBe listOf(
            Gear(
                adjacentParts = listOf(
                    EnginePart(100),
                    EnginePart(200)
                )
            )
        )
    }

})