package com.github.pawelkowalski92.aoc.day07.camel.rules

import com.github.pawelkowalski92.aoc.day07.camel.cards.Card
import com.github.pawelkowalski92.aoc.day07.camel.cards.Joker

class JokerCardParser(
    private val basicCardParser: CardParser
) : CardParser {
    override fun parseCard(label: Char): Card = when (label) {
        'J' -> Joker
        else -> basicCardParser.parseCard(label)
    }

}