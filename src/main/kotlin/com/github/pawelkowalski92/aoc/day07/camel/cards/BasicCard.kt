package com.github.pawelkowalski92.aoc.day07.camel.cards

data class BasicCard(
    private val strength: Int
): Card {

    override fun strength(): Int = strength
    override fun isWildcard(): Boolean = false

    companion object {
        val TWO = BasicCard(2)
        val THREE = BasicCard(3)
        val FOUR = BasicCard(4)
        val FIVE = BasicCard(5)
        val SIX = BasicCard(6)
        val SEVEN = BasicCard(7)
        val EIGHT = BasicCard(8)
        val NINE = BasicCard(9)
        val TEN = BasicCard(10)
        val JACK = BasicCard(11)
        val QUEEN = BasicCard(12)
        val KING = BasicCard(13)
        val ACE = BasicCard(14)

        private val ALL_CARDS: Map<Char, BasicCard> = mapOf(
            '2' to TWO,
            '3' to THREE,
            '4' to FOUR,
            '5' to FIVE,
            '6' to SIX,
            '7' to SEVEN,
            '8' to EIGHT,
            '9' to NINE,
            'T' to TEN,
            'J' to JACK,
            'Q' to QUEEN,
            'K' to KING,
            'A' to ACE
        )
        fun fromLabel(label: Char): BasicCard? = ALL_CARDS[label]

    }

}