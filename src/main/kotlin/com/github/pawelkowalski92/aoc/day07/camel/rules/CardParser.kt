package com.github.pawelkowalski92.aoc.day07.camel.rules

import com.github.pawelkowalski92.aoc.day07.camel.cards.Card

fun interface CardParser {

    fun parseCard(label: Char): Card

}