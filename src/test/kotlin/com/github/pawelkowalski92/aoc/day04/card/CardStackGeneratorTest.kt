package com.github.pawelkowalski92.aoc.day04.card

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CardStackGeneratorTest : ShouldSpec({

    should("process whole stack of lottery cards") {
        // given
        val stackGenerator = CardStackGenerator()

        // and
        val stack = listOf(
            Card(
                id = 1,
                winningNumbers = setOf(41, 48, 83, 86, 17),
                selectedNumbers = setOf(83, 86, 6, 31, 17, 9, 48, 53)
            ),
            Card(
                id = 2,
                winningNumbers = setOf(13, 32, 20, 16, 61),
                selectedNumbers = setOf(61, 30, 68, 82, 17, 32, 24, 19)
            ),
            Card(
                id = 3,
                winningNumbers = setOf(1, 21, 53, 59, 44),
                selectedNumbers = setOf(69, 82, 63, 72, 16, 21, 14, 1)
            ),
            Card(
                id = 4,
                winningNumbers = setOf(41, 92, 73, 84, 69),
                selectedNumbers = setOf(59, 84, 76, 51, 58, 5, 54, 83)
            ),
            Card(
                id = 5,
                winningNumbers = setOf(87, 83, 26, 28, 32),
                selectedNumbers = setOf(88, 30, 70, 12, 93, 22, 82, 36)
            ),
            Card(
                id = 6,
                winningNumbers = setOf(31, 18, 13, 56, 72),
                selectedNumbers = setOf(74, 77, 10, 23, 35, 67, 36, 11)
            )
        )

        // when
        val result = stackGenerator.buildWinningStack(stack)

        // then
        result.size shouldBe 30
    }

})