package com.github.pawelkowalski92.aoc.day06.race

class SingleRaceParser : RaceParser {

    override fun parseNumbers(input: String): List<Long> = input.split(':')[1]
        .filterNot(Char::isWhitespace).toLong().let(::listOf)

}