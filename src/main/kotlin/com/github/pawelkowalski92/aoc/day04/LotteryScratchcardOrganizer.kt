package com.github.pawelkowalski92.aoc.day04

import com.github.pawelkowalski92.aoc.day04.card.CardParser
import com.github.pawelkowalski92.aoc.day04.card.CardStackGenerator

class LotteryScratchcardOrganizer(
    private val parser: CardParser,
    private val stackGenerator: CardStackGenerator
) {

    fun organizeAllScratchcards(input: Collection<String>): Int = input.map(parser::parseCard)
        .let(stackGenerator::buildWinningStack)
        .size

}