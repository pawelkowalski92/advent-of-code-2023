package com.github.pawelkowalski92.aoc.day07.camel.cards

object Joker : Card {
    override fun strength(): Int = 1

    override fun isWildcard(): Boolean = true

    override fun toString(): String = "JOKER"

}