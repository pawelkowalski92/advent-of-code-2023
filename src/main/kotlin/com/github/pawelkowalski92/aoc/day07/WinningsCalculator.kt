package com.github.pawelkowalski92.aoc.day07

import com.github.pawelkowalski92.aoc.day07.camel.Game

class WinningsCalculator {

    fun calculateTotalWinnings(game: Game): Long =
        game.entriesSortedByWeakestHand.mapIndexed { ix, entry -> entry.bid * (ix + 1) }
            .sumOf { it.toLong() }

}