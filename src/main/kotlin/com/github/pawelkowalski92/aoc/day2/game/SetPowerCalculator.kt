package com.github.pawelkowalski92.aoc.day2.game

class SetPowerCalculator {

    fun calculatePower(draw: Draw): Int = draw.red * draw.green * draw.blue

}