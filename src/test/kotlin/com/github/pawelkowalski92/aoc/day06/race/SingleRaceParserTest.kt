package com.github.pawelkowalski92.aoc.day06.race

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class SingleRaceParserTest : ShouldSpec({

    should("parse race entries") {
        // given
        val raceParser = SingleRaceParser()

        // and
        val input = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )

        // when
        val result = raceParser.parseRace(input)

        // then
        result shouldBe listOf(
            Race(totalTime = 71530, currentRecord = 940200)
        )
    }

})