package com.github.pawelkowalski92.aoc.day07.camel

import com.github.pawelkowalski92.aoc.day07.camel.Game.GameEntry
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.FIVE
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.JACK
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.TEN
import com.github.pawelkowalski92.aoc.day07.camel.cards.Joker
import com.github.pawelkowalski92.aoc.day07.camel.rules.BasicCardParser
import com.github.pawelkowalski92.aoc.day07.camel.rules.JokerCardParser
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GameParserTest : ShouldSpec({

    val basicParser = BasicCardParser()
    val jokerParser = JokerCardParser(
        basicCardParser = basicParser
    )

    val firstGame = Game(
        entries = listOf(
            GameEntry(
                hand = Hand(
                    cards = listOf(TEN, FIVE, FIVE, JACK, FIVE)
                ),
                bid = 684
            )
        )
    )

    val secondGame = Game(
        entries = listOf(
            GameEntry(
                hand = Hand(
                    cards = listOf(TEN, FIVE, FIVE, Joker, FIVE)
                ),
                bid = 684
            )
        )
    )

    mapOf(
        basicParser to firstGame,
        jokerParser to secondGame
    ).forEach { (parser, expectedResult) ->
        should("parse game input using ${parser.javaClass.simpleName}") {
            // given
            val gameParser = GameParser(
                cardParser = parser
            )

            // and
            val input = listOf(
                "T55J5 684"
            )

            // when
            val result = gameParser.parseGame(input)

            // then
            result shouldBe expectedResult

        }
    }

})