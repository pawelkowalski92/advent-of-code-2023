package com.github.pawelkowalski92.aoc.day04

import com.github.pawelkowalski92.aoc.day04.card.CardParser
import com.github.pawelkowalski92.aoc.day04.card.CardValueCalculator

class LotteryChecker(
    private val parser: CardParser,
    private val calculator: CardValueCalculator
) {

    fun summarizeAllLotteryCards(input: Collection<String>): Int = input.map(parser::parseCard)
        .sumOf(calculator::calculateValue)

}