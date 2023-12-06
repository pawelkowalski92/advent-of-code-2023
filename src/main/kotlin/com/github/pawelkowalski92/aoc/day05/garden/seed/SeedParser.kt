package com.github.pawelkowalski92.aoc.day05.garden.seed

import java.util.stream.LongStream

fun interface SeedParser {

    fun transformSeeds(seed: List<Long>): LongStream

    fun parseSeeds(input: Collection<String>): LongStream = input.first().split(':')[1].trim()
        .split(' ').map(String::toLong)
        .let(::transformSeeds)

}