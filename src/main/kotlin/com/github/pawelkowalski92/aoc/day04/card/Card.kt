package com.github.pawelkowalski92.aoc.day04.card

data class Card(
    val id: Int,
    val winningNumbers: Set<Int>,
    val selectedNumbers: Set<Int>
) {
    val matchingCount: Int
        get() = selectedNumbers.filter { it in winningNumbers }.size
}