package com.github.pawelkowalski92.aoc.day05.garden.seed

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import kotlin.streams.toList

class RangeSeedParserTest : ShouldSpec({

    should("parse seeds") {
        // given
        val seedParser = RangeSeedParser()

        // and
        val input = listOf(
            "seeds: 79 14 55 13",
            ""
        )

        // when
        val result = seedParser.parseSeeds(input).toList()

        // then
        result shouldContainAll listOf(79L..<93L, 55L..<68L).flatten()
    }

})