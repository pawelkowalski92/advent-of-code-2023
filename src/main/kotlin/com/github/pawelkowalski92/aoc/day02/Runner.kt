package com.github.pawelkowalski92.aoc.day02

import com.github.pawelkowalski92.aoc.day02.game.Draw
import com.github.pawelkowalski92.aoc.day02.game.GameOptimizer
import com.github.pawelkowalski92.aoc.day02.game.GameParser
import com.github.pawelkowalski92.aoc.day02.game.GameValidator
import com.github.pawelkowalski92.aoc.day02.game.SetPowerCalculator
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val maximumDraw = Draw(red = 12, green = 13, blue = 14)
            val gameWithElf = GameWithElf(
                parser = GameParser(),
                validator = GameValidator(maximumDraw)
            )

            val result = getResource("inputs/day-2.txt").readLines()
                .let(gameWithElf::summarizeValidGames)
            println(result)
        }

    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val gameWithElf = SecondGameWithElf(
                parser = GameParser(),
                optimizer = GameOptimizer(),
                calculator = SetPowerCalculator()
            )

            val result = getResource("inputs/day-2.txt").readLines()
                .let(gameWithElf::summarizePowerOfMinimumDraws)
            println(result)
        }

    }

}