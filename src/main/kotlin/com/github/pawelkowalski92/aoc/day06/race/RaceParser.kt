package com.github.pawelkowalski92.aoc.day06.race

fun interface RaceParser {

    fun parseRace(input: Collection<String>): List<Race> {
        val time = input.elementAt(0).let(::parseNumbers)
        val distance = input.elementAt(1).let(::parseNumbers)
        return time.zip(distance).map {
            Race(
                totalTime = it.first,
                currentRecord = it.second
            )
        }
    }

    fun parseNumbers(input: String): List<Long>

}