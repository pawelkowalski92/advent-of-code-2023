package com.github.pawelkowalski92.aoc.day06.race

class BasicRaceParser : RaceParser {

    override fun parseNumbers(input: String): List<Long> = input.split(':')[1]
        .split(WHITESPACE_DELIMITER).mapNotNull(String::toLongOrNull)

    companion object {
        private val WHITESPACE_DELIMITER = Regex("\\s+")
    }

}