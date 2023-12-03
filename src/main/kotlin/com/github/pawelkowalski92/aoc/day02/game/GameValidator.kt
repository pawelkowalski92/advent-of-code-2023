package com.github.pawelkowalski92.aoc.day02.game

class GameValidator(
    private val maximumDraw: Draw
) {

    fun isGamePossible(game: Game): Boolean = game.draws.all(maximumDraw::contains)

}