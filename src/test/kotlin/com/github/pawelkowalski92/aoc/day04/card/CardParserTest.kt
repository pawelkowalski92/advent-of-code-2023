package com.github.pawelkowalski92.aoc.day04.card

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CardParserTest : ShouldSpec({

    should("parse card entry") {
        // given
        val parser = CardParser()

        // and
        val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"

        // when
        val result = parser.parseCard(input)

        // then
        result shouldBe Card(
            id = 1,
            winningNumbers = setOf(41, 48, 83, 86, 17),
            selectedNumbers = setOf(83, 86, 6, 31, 17, 9, 48, 53)
        )

    }
})