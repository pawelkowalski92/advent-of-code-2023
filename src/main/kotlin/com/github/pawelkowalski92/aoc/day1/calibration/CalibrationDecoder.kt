package com.github.pawelkowalski92.aoc.day1.calibration

fun interface CalibrationDecoder {

    fun calculateCalibrationValue(input: String): Int

}