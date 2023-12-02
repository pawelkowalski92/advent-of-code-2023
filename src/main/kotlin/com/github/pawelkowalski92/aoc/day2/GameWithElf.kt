package com.github.pawelkowalski92.aoc.day2

import com.github.pawelkowalski92.aoc.day2.game.Game
import com.github.pawelkowalski92.aoc.day2.game.GameParser
import com.github.pawelkowalski92.aoc.day2.game.GameValidator

class GameWithElf(
    private val parser: GameParser,
    private val validator: GameValidator
) {

    fun summarizeValidGames(input: Collection<String>): Int = input.map(parser::parseGame)
        .filter(validator::isGamePossible)
        .sumOf(Game::id)

}