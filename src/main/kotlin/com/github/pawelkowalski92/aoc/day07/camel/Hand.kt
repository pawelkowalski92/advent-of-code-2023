package com.github.pawelkowalski92.aoc.day07.camel

import com.github.pawelkowalski92.aoc.day07.camel.Result.FIVE_OF_A_KIND
import com.github.pawelkowalski92.aoc.day07.camel.Result.FOUR_OF_A_KIND
import com.github.pawelkowalski92.aoc.day07.camel.Result.FULL_HOUSE
import com.github.pawelkowalski92.aoc.day07.camel.Result.HIGH_CARD
import com.github.pawelkowalski92.aoc.day07.camel.Result.ONE_PAIR
import com.github.pawelkowalski92.aoc.day07.camel.Result.THREE_OF_A_KIND
import com.github.pawelkowalski92.aoc.day07.camel.Result.TWO_PAIR
import com.github.pawelkowalski92.aoc.day07.camel.cards.Card

data class Hand(
    val cards: List<Card>
) : Comparable<Hand> {

    val result: Result
        get() {
            val noWildcards = cards.filterNot(Card::isWildcard)
                .groupingBy { it }.eachCount()
            val wildcardsCount = cards.count(Card::isWildcard)
            val maximumSet = (noWildcards.values.maxOrNull() ?: 0) + wildcardsCount
            return when (noWildcards.size) {
                0 -> FIVE_OF_A_KIND // only wildcards
                1 -> FIVE_OF_A_KIND
                2 -> when (maximumSet) {
                    4 -> FOUR_OF_A_KIND
                    else -> FULL_HOUSE
                }

                3 -> when (maximumSet) {
                    3 -> THREE_OF_A_KIND
                    else -> TWO_PAIR
                }

                4 -> ONE_PAIR
                else -> HIGH_CARD
            }
        }

    override fun compareTo(other: Hand): Int = result.compareTo(other.result).takeIf { it != 0 }
        ?: cards.zip(other.cards, Card::compareTo).firstOrNull { it != 0 }
        ?: 0

}
