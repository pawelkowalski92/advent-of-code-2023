package com.github.pawelkowalski92.aoc.day02.game

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class SetPowerCalculatorTest : ShouldSpec({

    should("calculate power of set") {
        // given
        val calculator = SetPowerCalculator()

        // and
        val draw = Draw(red = 4, green = 2, blue = 6)

        // when
        val result = calculator.calculatePower(draw)

        // then
        result shouldBe 48
    }

})