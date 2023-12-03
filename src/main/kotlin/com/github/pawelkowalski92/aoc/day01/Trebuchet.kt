package com.github.pawelkowalski92.aoc.day01

import com.github.pawelkowalski92.aoc.day01.calibration.CalibrationDecoder

class Trebuchet(
    private val decoder: CalibrationDecoder
) {
    fun decodeCalibrationDocument(input: Collection<String>): Int = input.sumOf(decoder::calculateCalibrationValue)

}