package com.github.pawelkowalski92.aoc.day03.engine.locators

import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GearPartLocatorTest : ShouldSpec({

    should("locate gears in schematics part") {
        // given
        val gearPartLocator = GearPartLocator()

        // and
        val schematics = SchematicsPart("*200.400")

        // when
        val result = gearPartLocator.locateParts(schematics)

        // then
        result shouldBe listOf(
            PartLocation(schematics, 0)
        )
    }

})