package com.github.pawelkowalski92.aoc.day02.game

data class Game(
    val id: Int,
    val draws: List<Draw>
)

data class Draw(
    val red: Int,
    val green: Int,
    val blue: Int
) {

    fun contains(other: Draw): Boolean = other.red <= red && other.green <= green && other.blue <= blue

}