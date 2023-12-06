package com.github.pawelkowalski92.aoc.day02.game

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GameOptimizerTest : ShouldSpec({

    should("optimize game") {
        // given
        val optimizer = GameOptimizer()

        // and
        val game = Game(
            id = 1,
            draws = listOf(
                Draw(red = 4, green = 0, blue = 3),
                Draw(red = 1, green = 2, blue = 6),
                Draw(red = 0, green = 2, blue = 0)
            )
        )

        // when
        val result = optimizer.findMinimumDraw(game)

        // then
        result shouldBe Draw(
            red = 4,
            green = 2,
            blue = 6
        )
    }

})