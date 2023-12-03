package com.github.pawelkowalski92.aoc.day01.calibration

fun interface CalibrationDecoder {

    fun calculateCalibrationValue(input: String): Int

}