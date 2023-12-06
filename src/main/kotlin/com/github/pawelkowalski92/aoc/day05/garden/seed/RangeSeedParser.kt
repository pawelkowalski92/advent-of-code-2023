package com.github.pawelkowalski92.aoc.day05.garden.seed

import java.util.stream.LongStream

class RangeSeedParser : SeedParser {
    override fun transformSeeds(seed: List<Long>): LongStream =
        seed.chunked(2) { LongStream.range(it[0], it[0] + it[1]) }.parallelStream().flatMapToLong { it }

}