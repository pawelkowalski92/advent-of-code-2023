package com.github.pawelkowalski92.aoc.day03.engine.locators

import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumericPartLocatorTest : ShouldSpec({

    should("locate numeric parts in schematics part") {
        // given
        val numericPartLocator = NumericPartLocator()

        // and
        val schematics = SchematicsPart("*200.400")

        // when
        val result = numericPartLocator.locateParts(schematics)

        // then
        result shouldBe listOf(
            PartLocation(schematics, 1 .. 3),
            PartLocation(schematics, 5 .. 7)
        )
    }

})