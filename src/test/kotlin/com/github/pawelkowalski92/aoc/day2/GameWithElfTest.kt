package com.github.pawelkowalski92.aoc.day2

import com.github.pawelkowalski92.aoc.day2.game.Draw
import com.github.pawelkowalski92.aoc.day2.game.GameParser
import com.github.pawelkowalski92.aoc.day2.game.GameValidator
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GameWithElfTest : ShouldSpec({

    should("summarize id of valid games") {
        // given
        val maximumDraw = Draw(red = 12, green = 13, blue = 14)
        val gameWithElf = GameWithElf(
            parser = GameParser(),
            validator = GameValidator(maximumDraw)
        )

        // and
        val input = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )

        // when
        val result = gameWithElf.summarizeValidGames(input)

        // then
        result shouldBe 8
    }

})