package com.github.pawelkowalski92.aoc.day06

import com.github.pawelkowalski92.aoc.day06.race.BasicRaceParser
import com.github.pawelkowalski92.aoc.day06.race.Boat
import com.github.pawelkowalski92.aoc.day06.race.SingleRaceParser
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val errorMarginCalculator = ErrorMarginCalculator(
                raceParser = BasicRaceParser(),
                boat = Boat()
            )

            val result = getResource("inputs/day-6.txt").readLines()
                .let(errorMarginCalculator::calculateErrorMargin)
            println(result)
        }

    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val errorMarginCalculator = ErrorMarginCalculator(
                raceParser = SingleRaceParser(),
                boat = Boat()
            )

            val result = getResource("inputs/day-6.txt").readLines()
                .let(errorMarginCalculator::calculateErrorMargin)
            println(result)
        }

    }

}