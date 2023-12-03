package com.github.pawelkowalski92.aoc.day02.game

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GameParserTest : ShouldSpec({

    should("parse game entry") {
        // given
        val parser = GameParser()

        // and
        val input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

        // when
        val result = parser.parseGame(input)

        // then
        result shouldBe Game(
            id = 1,
            draws = listOf(
                Draw(red = 4, green = 0, blue = 3),
                Draw(red = 1, green = 2, blue = 6),
                Draw(red = 0, green = 2, blue = 0)
            )
        )

    }
})