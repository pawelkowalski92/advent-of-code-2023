package com.github.pawelkowalski92.aoc.day04.card

class CardParser {

    fun parseCard(input: String): Card = input.split(':').let {
        val numbers = it[1].split('|')
        Card(
            id = extractCardId(it[0]),
            winningNumbers = extractNumbers(numbers[0]),
            selectedNumbers = extractNumbers(numbers[1])
        )
    }

    private fun extractCardId(input: String): Int = WHITESPACE_DELIMITER.let(input::split)[1].toInt()

    private fun extractNumbers(input: String): Set<Int> = WHITESPACE_DELIMITER.let(input::split)
        .mapNotNull { it.trim().takeIf(String::isNotEmpty) }
        .map(String::toInt)
        .toSet()

    companion object {
        private val WHITESPACE_DELIMITER = Regex("\\s+")
    }
}