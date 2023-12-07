package com.github.pawelkowalski92.aoc.day07.camel.rules

import com.github.pawelkowalski92.aoc.day07.camel.cards.BasicCard
import com.github.pawelkowalski92.aoc.day07.camel.cards.Card

class BasicCardParser : CardParser {
    override fun parseCard(label: Char): Card = BasicCard.fromLabel(label)
        ?: throw IllegalArgumentException("Unknown card label: '$label'")

}