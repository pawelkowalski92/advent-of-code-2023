package com.github.pawelkowalski92.aoc.day06.race

data class Boat(
    private var velocity: Long = 0
) {
    fun charge(time: Long): Boat = also { velocity = time }

    fun move(time: Long): Long = velocity * time
}