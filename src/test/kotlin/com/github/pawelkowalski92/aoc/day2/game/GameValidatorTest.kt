package com.github.pawelkowalski92.aoc.day2.game

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GameValidatorTest : ShouldSpec({

    should("determine game to be possible") {
        // given
        val maximumDraw = Draw(red = 12, green = 13, blue = 14)
        val validator = GameValidator(maximumDraw)

        // and
        val input = Game(
            id = 1,
            draws = listOf(
                Draw(red = 4, green = 0, blue = 3),
                Draw(red = 1, green = 2, blue = 6),
                Draw(red = 0, green = 2, blue = 0)
            )
        )

        // when
        val result = validator.isGamePossible(input)

        // then
        result shouldBe true

    }

    should("determine game to be impossible") {
        // given
        val maximumDraw = Draw(red = 12, green = 13, blue = 14)
        val validator = GameValidator(maximumDraw)

        // and
        val input = Game(
            id = 1,
            draws = listOf(
                Draw(red = 20, green = 8, blue = 6),
                Draw(red = 4, green = 13, blue = 5),
                Draw(red = 1, green = 5, blue = 0)
            )
        )

        // when
        val result = validator.isGamePossible(input)

        // then
        result shouldBe false

    }

})