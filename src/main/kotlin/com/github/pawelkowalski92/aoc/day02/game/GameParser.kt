package com.github.pawelkowalski92.aoc.day02.game

class GameParser {

    fun parseGame(input: String): Game = input.split(':').let {
        Game(
            id = extractGameId(it[0]),
            draws = extractDraws(it[1])
        )
    }

    private fun extractGameId(input: String): Int = input.split(' ')[1].toInt()

    private fun extractDraws(input: String): List<Draw> = input.split(';').map(this::extractDraw)

    private fun extractDraw(input: String): Draw {
        val draws = input.split(',').map(String::trim).associate {
            val draw = it.split(' ')
            draw[1] to draw[0].toInt()
        }
        return Draw(
            red = draws["red"] ?: 0,
            green = draws["green"] ?: 0,
            blue = draws["blue"] ?: 0
        )
    }

}