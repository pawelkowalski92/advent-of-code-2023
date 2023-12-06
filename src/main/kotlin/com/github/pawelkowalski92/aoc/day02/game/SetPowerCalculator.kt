package com.github.pawelkowalski92.aoc.day02.game

class SetPowerCalculator {

    fun calculatePower(draw: Draw): Int = draw.red * draw.green * draw.blue

}