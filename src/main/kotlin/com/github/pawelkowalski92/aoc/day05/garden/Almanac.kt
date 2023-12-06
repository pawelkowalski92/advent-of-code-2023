package com.github.pawelkowalski92.aoc.day05.garden

data class Almanac(
    private val seedToSoil: Instructions,
    private val soilToFertilizer: Instructions,
    private val fertilizerToWater: Instructions,
    private val waterToLight: Instructions,
    private val lightToTemperature: Instructions,
    private val temperatureToHumidity: Instructions,
    private val humidityToLocation: Instructions
) {
    fun findSeedLocation(seed: Long): Long = seed
        .let(seedToSoil::findDestinationReference)
        .let(soilToFertilizer::findDestinationReference)
        .let(fertilizerToWater::findDestinationReference)
        .let(waterToLight::findDestinationReference)
        .let(lightToTemperature::findDestinationReference)
        .let(temperatureToHumidity::findDestinationReference)
        .let(humidityToLocation::findDestinationReference)

}