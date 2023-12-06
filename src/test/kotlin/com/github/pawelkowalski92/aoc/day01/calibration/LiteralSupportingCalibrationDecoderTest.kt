package com.github.pawelkowalski92.aoc.day01.calibration

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class LiteralSupportingCalibrationDecoderTest: ShouldSpec({
    val decoder: CalibrationDecoder = LiteralSupportingCalibrationDecoder()

    mapOf(
        "two1nine" to 29,
        "eightwothree" to 83,
        "abcone2threexyz" to 13,
        "xtwone3four" to 24,
        "4nineeightseven2" to 42,
        "zoneight234" to 14,
        "7pqrstsixteen" to 76
    ).forEach { (entry, expected) ->
        should("calculate calibration value: $expected from: $entry") {
            decoder.calculateCalibrationValue(entry) shouldBe expected
        }
    }

})