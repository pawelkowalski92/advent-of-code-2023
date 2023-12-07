package com.github.pawelkowalski92.aoc.day07.camel.cards

interface Card: Comparable<Card> {

    fun strength(): Int

    fun isWildcard(): Boolean

    override fun compareTo(other: Card): Int = strength().compareTo(other.strength())

}