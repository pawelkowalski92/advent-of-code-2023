package com.github.pawelkowalski92.aoc.day01

import com.github.pawelkowalski92.aoc.day01.calibration.LiteralSupportingCalibrationDecoder
import com.github.pawelkowalski92.aoc.day01.calibration.SimpleCalibrationDecoder
import com.github.pawelkowalski92.aoc.util.getResource

class Runner {

    object Part1 {
        @JvmStatic
        fun main(vararg args: String) {
            val decoder = SimpleCalibrationDecoder()
            val trebuchet = Trebuchet(decoder)

            val result = getResource("inputs/day-1.txt").readLines()
                .let(trebuchet::decodeCalibrationDocument)
            println(result)
        }

    }

    object Part2 {

        @JvmStatic
        fun main(vararg args: String) {
            val decoder = LiteralSupportingCalibrationDecoder()
            val trebuchet = Trebuchet(decoder)

            val result = getResource("inputs/day-1.txt").readLines()
                .let(trebuchet::decodeCalibrationDocument)
            println(result)
        }

    }

}