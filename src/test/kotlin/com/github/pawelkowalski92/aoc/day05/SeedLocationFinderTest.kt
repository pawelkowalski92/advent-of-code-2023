package com.github.pawelkowalski92.aoc.day05

import com.github.pawelkowalski92.aoc.day05.garden.Almanac
import com.github.pawelkowalski92.aoc.day05.garden.Instructions
import com.github.pawelkowalski92.aoc.day05.garden.Instructions.InstructionsEntry
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.util.stream.LongStream

class SeedLocationFinderTest : ShouldSpec({

    should("find lowest seed location") {
        // given
        val seedLocationFinder = SeedLocationFinder(
            almanac = Almanac(
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
        )

        // and
        val seed = LongStream.of(79, 14, 55, 13)

        // when
        val result = seedLocationFinder.findLowestSeedLocation(seed)

        // then
        result shouldBe 35
    }

})