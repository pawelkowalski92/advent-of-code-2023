package com.github.pawelkowalski92.aoc.day2.game

class GameOptimizer {

    fun findMinimumDraw(game: Game): Draw = Draw(
        red = game.draws.maxBy(Draw::red).red,
        green = game.draws.maxBy(Draw::green).green,
        blue = game.draws.maxBy(Draw::blue).blue
    )

}