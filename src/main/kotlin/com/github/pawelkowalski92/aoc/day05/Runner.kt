package com.github.pawelkowalski92.aoc.day05

import com.github.pawelkowalski92.aoc.day05.garden.AlmanacParser
import com.github.pawelkowalski92.aoc.day05.garden.seed.BasicSeedParser
import com.github.pawelkowalski92.aoc.day05.garden.seed.RangeSeedParser
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val almanacParser = AlmanacParser()
            val seedParser = BasicSeedParser()

            val result = getResource("inputs/day-5.txt").readLines()
                .let {
                    val seedLocationFinder = almanacParser.parseAlmanach(it).let(::SeedLocationFinder)
                    seedParser.parseSeeds(it).let(seedLocationFinder::findLowestSeedLocation)
                }
            println(result)
        }

    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val almanacParser = AlmanacParser()
            val seedParser = RangeSeedParser()

            val result = getResource("inputs/day-5.txt").readLines()
                .let {
                    val seedLocationFinder = almanacParser.parseAlmanach(it).let(::SeedLocationFinder)
                    seedParser.parseSeeds(it).let(seedLocationFinder::findLowestSeedLocation)
                }
            println(result)
        }

    }

}