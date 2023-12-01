package com.github.pawelkowalski92.aoc.day1.calibration

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class SimpleCalibrationDecoderTest : ShouldSpec({
    val decoder: CalibrationDecoder = SimpleCalibrationDecoder()

    mapOf(
        "1abc2" to 12,
        "pqr3stu8vwx" to 38,
        "a1b2c3d4e5f" to 15,
        "treb7uchet" to 77
    ).forEach { (entry, expected) ->
        should("calculate calibration value: $expected from: $entry") {
            decoder.calculateCalibrationValue(entry) shouldBe expected
        }
    }

})