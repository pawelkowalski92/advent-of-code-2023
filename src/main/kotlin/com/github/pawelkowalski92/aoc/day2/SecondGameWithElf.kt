package com.github.pawelkowalski92.aoc.day2

import com.github.pawelkowalski92.aoc.day2.game.GameOptimizer
import com.github.pawelkowalski92.aoc.day2.game.GameParser
import com.github.pawelkowalski92.aoc.day2.game.SetPowerCalculator

class SecondGameWithElf(
    private val parser: GameParser,
    private val optimizer: GameOptimizer,
    private val calculator: SetPowerCalculator
) {

    fun summarizePowerOfMinimumDraws(input: Collection<String>): Int = input.map(parser::parseGame)
        .map(optimizer::findMinimumDraw)
        .sumOf(calculator::calculatePower)

}