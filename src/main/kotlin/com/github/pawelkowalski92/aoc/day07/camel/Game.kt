package com.github.pawelkowalski92.aoc.day07.camel

data class Game(
    private val entries: List<GameEntry>
) {

    val entriesSortedByWeakestHand: List<GameEntry> = entries.sortedBy(GameEntry::hand)

    data class GameEntry(
        val hand: Hand,
        val bid: Int
    )

}