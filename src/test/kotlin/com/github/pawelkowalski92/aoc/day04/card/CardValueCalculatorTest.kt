package com.github.pawelkowalski92.aoc.day04.card

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CardValueCalculatorTest : ShouldSpec({

    should("calculate value of a card") {
        // given
        val calculator = CardValueCalculator()

        // and
        val card = Card(
            id = 1,
            winningNumbers = setOf(41, 48, 83, 86, 17),
            selectedNumbers = setOf(83, 86, 6, 31, 17, 9, 48, 53)
        )

        // when
        val result = calculator.calculateValue(card)

        // then
        result shouldBe 8
    }

})