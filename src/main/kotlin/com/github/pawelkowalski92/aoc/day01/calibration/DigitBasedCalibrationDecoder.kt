package com.github.pawelkowalski92.aoc.day01.calibration

abstract class DigitBasedCalibrationDecoder : CalibrationDecoder {

    protected abstract fun firstDigit(input: String): Int

    protected abstract fun lastDigit(input: String): Int

    override fun calculateCalibrationValue(input: String): Int = firstDigit(input) * 10 + lastDigit(input)

}