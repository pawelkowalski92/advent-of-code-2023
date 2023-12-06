package com.github.pawelkowalski92.aoc.day05.garden.seed

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import kotlin.streams.toList

class BasicSeedParserTest : ShouldSpec({

    should("parse seeds") {
        // given
        val seedParser = BasicSeedParser()

        // and
        val input = listOf(
            "seeds: 79 14 55 13",
            ""
        )

        // when
        val result = seedParser.parseSeeds(input).toList()

        // then
        result shouldContainAll listOf(79L, 14L, 55L, 13L)
    }

})