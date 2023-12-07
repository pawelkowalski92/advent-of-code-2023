package com.github.pawelkowalski92.aoc.day07.camel.rules

import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.ACE
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.FIVE
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.JACK
import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard.Companion.TWO
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BasicCardParserTest : ShouldSpec({

    mapOf(
        '2' to TWO,
        '5' to FIVE,
        'J' to JACK,
        'A' to ACE
    ).forEach { (label, card) ->
        should("parse $label into $card") {
            // given
            val parser = BasicCardParser()

            // when
            val result = parser.parseCard(label)

            // then
            result shouldBe card
        }
    }

})