package com.github.pawelkowalski92.aoc.day06

import com.github.pawelkowalski92.aoc.day06.race.Boat
import com.github.pawelkowalski92.aoc.day06.race.RaceParser

class ErrorMarginCalculator(
    private val raceParser: RaceParser,
    private val boat: Boat
) {

    fun calculateErrorMargin(input: Collection<String>): Int =
        raceParser.parseRace(input)
            .map { it.findWinningStrategies(boat).size }
            .reduce(Int::times)

}