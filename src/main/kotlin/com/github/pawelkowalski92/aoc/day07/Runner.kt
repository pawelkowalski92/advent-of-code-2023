package com.github.pawelkowalski92.aoc.day07

import com.github.pawelkowalski92.aoc.day07.camel.GameParser
import com.github.pawelkowalski92.aoc.day07.camel.rules.BasicCardParser
import com.github.pawelkowalski92.aoc.day07.camel.rules.JokerCardParser
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val cardParser = BasicCardParser()
            val gameParser = GameParser(
                cardParser = cardParser
            )
            val winningsCalculator = WinningsCalculator()

            val result = getResource("inputs/day-7.txt").readLines()
                .let(gameParser::parseGame)
                .let(winningsCalculator::calculateTotalWinnings)
            println(result)
        }

    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val cardParser = JokerCardParser(
                basicCardParser = BasicCardParser()
            )
            val gameParser = GameParser(
                cardParser = cardParser
            )
            val winningsCalculator = WinningsCalculator()

            val result = getResource("inputs/day-7.txt").readLines()
                .let(gameParser::parseGame)
                .let(winningsCalculator::calculateTotalWinnings)
            println(result)
        }

    }

}