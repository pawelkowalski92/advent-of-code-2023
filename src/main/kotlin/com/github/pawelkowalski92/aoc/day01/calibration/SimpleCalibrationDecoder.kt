package com.github.pawelkowalski92.aoc.day01.calibration

class SimpleCalibrationDecoder: DigitBasedCalibrationDecoder() {

    override fun firstDigit(input: String): Int = input.find(Char::isDigit)?.digitToInt()
        ?: throw IllegalArgumentException("Digit not found in $input")

    override fun lastDigit(input: String): Int = input.findLast(Char::isDigit)?.digitToInt()
        ?: throw IllegalArgumentException("Digit not found in $input")

}