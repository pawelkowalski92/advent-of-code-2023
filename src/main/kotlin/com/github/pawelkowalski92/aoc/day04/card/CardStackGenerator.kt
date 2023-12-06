package com.github.pawelkowalski92.aoc.day04.card

class CardStackGenerator {
    fun buildWinningStack(originalStack: List<Card>): List<Card> {
        val stackOrganizer = StackOrganizer(
            cardMap = originalStack.associateBy(Card::id)
        )
        return mutableListOf<Card>().apply {
            var newStack = originalStack.also(::addAll)
            while (newStack.isNotEmpty()) {
                newStack = newStack.flatMap(stackOrganizer::exchange).also(::addAll)
            }
        }
    }

    private class StackOrganizer(val cardMap: Map<Int, Card>) {

        fun exchange(card: Card): List<Card> = card.matchingCount.takeIf { it > 0 }
            ?.let { (card.id + 1..card.id + it).mapNotNull(cardMap::get) }
            ?: listOf()

    }

}