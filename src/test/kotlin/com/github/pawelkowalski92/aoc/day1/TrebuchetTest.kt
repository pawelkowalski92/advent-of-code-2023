package com.github.pawelkowalski92.aoc.day1

import com.github.pawelkowalski92.aoc.day1.calibration.CalibrationDecoder
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class TrebuchetTest : ShouldSpec({

    should("calculate calibration values") {
        // given
        val decoder = CalibrationDecoder { it.length }
        val trebuchet = Trebuchet(decoder)

        // and
        val input = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        )

        // when
        val result = trebuchet.decodeCalibrationDocument(input)

        // then
        result shouldBe 86

    }
})