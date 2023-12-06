package com.github.pawelkowalski92.aoc.day06.race

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BasicRaceParserTest : ShouldSpec({

    should("parse race entries") {
        // given
        val raceParser = BasicRaceParser()

        // and
        val input = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )

        // when
        val result = raceParser.parseRace(input)

        // then
        result shouldBe listOf(
            Race(totalTime = 7, currentRecord = 9),
            Race(totalTime = 15, currentRecord = 40),
            Race(totalTime = 30, currentRecord = 200)
        )
    }

})