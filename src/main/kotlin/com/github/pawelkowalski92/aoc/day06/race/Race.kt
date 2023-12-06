package com.github.pawelkowalski92.aoc.day06.race

data class Race(
    private val totalTime: Long,
    private val currentRecord: Long
) {

    private val possibleStrategies: List<RaceStrategy> = (0..totalTime).map {
        RaceStrategy(
            chargingTime = it,
            travelTime = totalTime - it
        )
    }

    fun findWinningStrategies(boat: Boat): List<RaceStrategy> =
        possibleStrategies.filter { it.test(boat) > currentRecord }

    data class RaceStrategy(
        val chargingTime: Long,
        val travelTime: Long
    ) {
        fun test(boat: Boat): Long = boat.charge(chargingTime).move(travelTime)

    }
}