package com.github.pawelkowalski92.aoc.day07

import com.github.pawelkowalski92.aoc.day07.camel.Game
import com.github.pawelkowalski92.aoc.day07.camel.Game.GameEntry
import com.github.pawelkowalski92.aoc.day07.camel.Hand
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.ACE
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.FIVE
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.JACK
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.KING
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.QUEEN
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.SEVEN
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.SIX
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.TEN
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.THREE
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.TWO
import com.github.pawelkowalski92.aoc.day07.camel.cards.Joker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class WinningsCalculatorTest : ShouldSpec({

    val firstGame = Game(
        entries = listOf(
            GameEntry(
                hand = Hand(
                    cards = listOf(THREE, TWO, TEN, THREE, KING)
                ),
                bid = 765
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(TEN, FIVE, FIVE, JACK, FIVE)
                ),
                bid = 684
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(KING, KING, SIX, SEVEN, SEVEN)
                ),
                bid = 28
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(KING, TEN, JACK, JACK, TEN)
                ),
                bid = 220
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(QUEEN, QUEEN, QUEEN, JACK, ACE)
                ),
                bid = 483
            ),
        )
    )

    val secondGame = Game(
        entries = listOf(
            GameEntry(
                hand = Hand(
                    cards = listOf(THREE, TWO, TEN, THREE, KING)
                ),
                bid = 765
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(TEN, FIVE, FIVE, Joker, FIVE)
                ),
                bid = 684
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(KING, KING, SIX, SEVEN, SEVEN)
                ),
                bid = 28
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(KING, TEN, Joker, Joker, TEN)
                ),
                bid = 220
            ),
            GameEntry(
                hand = Hand(
                    cards = listOf(QUEEN, QUEEN, QUEEN, Joker, ACE)
                ),
                bid = 483
            ),
        )
    )

    mapOf(
        firstGame to 6440L,
        secondGame to 5905L
    ).forEach { (game, expectedResult) ->
        should("calculate total winnings for $game") {
            // given
            val winningsCalculator = WinningsCalculator()

            // when
            val result = winningsCalculator.calculateTotalWinnings(game)

            // then
            result shouldBe expectedResult
        }
    }

})