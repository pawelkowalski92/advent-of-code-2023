package com.github.pawelkowalski92.aoc.day05.garden.seed

import java.util.stream.LongStream

class BasicSeedParser : SeedParser {

    override fun transformSeeds(seed: List<Long>): LongStream = seed.stream().mapToLong { it }

}