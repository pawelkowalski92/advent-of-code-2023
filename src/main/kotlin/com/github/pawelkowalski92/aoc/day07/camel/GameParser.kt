package com.github.pawelkowalski92.aoc.day07.camel

import com.github.pawelkowalski92.aoc.day07.camel.Game.GameEntry
import com.github.pawelkowalski92.aoc.day07.camel.rules.CardParser

class GameParser(
    private val cardParser: CardParser
) {

    fun parseGame(input: Collection<String>): Game = input.map(::parseGameEntry).let(::Game)

    private fun parseGameEntry(input: String): GameEntry = input.split(' ').let {
        GameEntry(
            hand = it[0].let(::parseHand),
            bid = it[1].toInt()
        )
    }

    private fun parseHand(input: String): Hand = input.mapNotNull(cardParser::parseCard).let(::Hand)

}