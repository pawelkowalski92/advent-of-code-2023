package com.github.pawelkowalski92.aoc.day04

import com.github.pawelkowalski92.aoc.day04.card.CardParser
import com.github.pawelkowalski92.aoc.day04.card.CardStackGenerator
import com.github.pawelkowalski92.aoc.day04.card.CardValueCalculator
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val lotteryChecker = LotteryChecker(
                parser = CardParser(),
                calculator = CardValueCalculator()
            )

            val result = getResource("inputs/day-4.txt").readLines()
                .let(lotteryChecker::summarizeAllLotteryCards)
            println(result)
        }
    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val lotteryScratchcardOrganizer = LotteryScratchcardOrganizer(
                parser = CardParser(),
                stackGenerator = CardStackGenerator()
            )

            val result = getResource("inputs/day-4.txt").readLines()
                .let(lotteryScratchcardOrganizer::organizeAllScratchcards)
            println(result)
        }

    }

}