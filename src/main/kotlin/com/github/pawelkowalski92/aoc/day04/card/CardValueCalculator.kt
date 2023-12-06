package com.github.pawelkowalski92.aoc.day04.card

class CardValueCalculator {

    fun calculateValue(card: Card) = card.matchingCount.takeIf { it > 0 }
        ?.let { 1 shl (it - 1) } ?: 0


}