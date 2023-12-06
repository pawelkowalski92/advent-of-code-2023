package com.github.pawelkowalski92.aoc.day05

import com.github.pawelkowalski92.aoc.day05.garden.Almanac
import java.util.stream.LongStream

class SeedLocationFinder(
    private val almanac: Almanac
) {

    fun findLowestSeedLocation(seeds: LongStream): Long = seeds.map(almanac::findSeedLocation).min().asLong

}