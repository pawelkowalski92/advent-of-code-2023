package com.github.pawelkowalski92.aoc.day06

import com.github.pawelkowalski92.aoc.day06.race.BasicRaceParser
import com.github.pawelkowalski92.aoc.day06.race.Boat
import com.github.pawelkowalski92.aoc.day06.race.SingleRaceParser
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ErrorMarginCalculatorTest : ShouldSpec({

    should("calculate error margin using basic race parser") {
        // given
        val errorMarginCalculator = ErrorMarginCalculator(
            raceParser = BasicRaceParser(),
            boat = Boat()
        )

        // and
        val input = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )

        // when
        val result = errorMarginCalculator.calculateErrorMargin(input)

        // then
        result shouldBe 288
    }

    should("calculate error margin using single race parser") {
        // given
        val errorMarginCalculator = ErrorMarginCalculator(
            raceParser = SingleRaceParser(),
            boat = Boat()
        )

        // and
        val input = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )

        // when
        val result = errorMarginCalculator.calculateErrorMargin(input)

        // then
        result shouldBe 71503
    }

})