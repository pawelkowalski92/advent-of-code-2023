package com.github.pawelkowalski92.aoc.day05.garden

import com.github.pawelkowalski92.aoc.day05.garden.Instructions.InstructionsEntry
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class AlmanacParserTest : ShouldSpec({

    should("parse almanac content") {
        // given
        val almanacParser = AlmanacParser()

        // and
        val input = listOf(
            "seeds: 79 14 55 13",
            "",
            "seed-to-soil map:",
            "50 98 2",
            "52 50 48",
            "",
            "soil-to-fertilizer map:",
            "0 15 37",
            "37 52 2",
            "39 0 15",
            "",
            "fertilizer-to-water map:",
            "49 53 8",
            "0 11 42",
            "42 0 7",
            "57 7 4",
            "",
            "water-to-light map:",
            "88 18 7",
            "18 25 70",
            "",
            "light-to-temperature map:",
            "45 77 23",
            "81 45 19",
            "68 64 13",
            "",
            "temperature-to-humidity map:",
            "0 69 1",
            "1 0 69",
            "",
            "humidity-to-location map:",
            "60 56 37",
            "56 93 4"
        )

        // when
        val result = almanacParser.parseAlmanach(input)

        // then
        result shouldBe Almanac(
            seedToSoil = Instructions(
                listOf(
                    InstructionsEntry(destination = 50, source = 98, range = 2),
                    InstructionsEntry(destination = 52, source = 50, range = 48)
                )
            ),
            soilToFertilizer = Instructions(
                listOf(
                    InstructionsEntry(destination = 0, source = 15, range = 37),
                    InstructionsEntry(destination = 37, source = 52, range = 2),
                    InstructionsEntry(destination = 39, source = 0, range = 15)
                )
            ),
            fertilizerToWater = Instructions(
                listOf(
                    InstructionsEntry(destination = 49, source = 53, range = 8),
                    InstructionsEntry(destination = 0, source = 11, range = 42),
                    InstructionsEntry(destination = 42, source = 0, range = 7),
                    InstructionsEntry(destination = 57, source = 7, range = 4)
                )
            ),
            waterToLight = Instructions(
                listOf(
                    InstructionsEntry(destination = 88, source = 18, range = 7),
                    InstructionsEntry(destination = 18, source = 25, range = 70)
                )
            ),
            lightToTemperature = Instructions(
                listOf(
                    InstructionsEntry(destination = 45, source = 77, range = 23),
                    InstructionsEntry(destination = 81, source = 45, range = 19),
                    InstructionsEntry(destination = 68, source = 64, range = 13)
                )
            ),
            temperatureToHumidity = Instructions(
                listOf(
                    InstructionsEntry(destination = 0, source = 69, range = 1),
                    InstructionsEntry(destination = 1, source = 0, range = 69)
                )
            ),
            humidityToLocation = Instructions(
                listOf(
                    InstructionsEntry(destination = 60, source = 56, range = 37),
                    InstructionsEntry(destination = 56, source = 93, range = 4)
                )
            )
        )
    }

})