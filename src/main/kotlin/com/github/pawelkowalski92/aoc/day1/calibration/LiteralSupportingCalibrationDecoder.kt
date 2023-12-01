package com.github.pawelkowalski92.aoc.day1.calibration

class LiteralSupportingCalibrationDecoder : DigitBasedCalibrationDecoder() {

    override fun firstDigit(input: String): Int {
        val buffer = DigitBuffer()
        for (c in input) {
            val digit = buffer.append(c).digit
            if (digit != null) return digit
        }
        throw IllegalArgumentException("Digit not found in $input")
    }

    override fun lastDigit(input: String): Int {
        val buffer = DigitBuffer()
        for (c in input.reversed()) {
            val digit = buffer.prepend(c).digit
            if (digit != null) return digit
        }
        throw IllegalArgumentException("Digit not found in $input")
    }

    private class DigitBuffer(
        val buffer: StringBuilder = StringBuilder()
    ) {
        val rawDigit: Int?
            get() = buffer.singleOrNull(Char::isDigit)?.digitToInt()

        val literalDigit: Int?
            get() = LITERAL_DIGIT_MAP.keys.find(buffer::contains)?.let(LITERAL_DIGIT_MAP::get)

        val digit: Int?
            get() = rawDigit ?: literalDigit

        fun prepend(char: Char): DigitBuffer = also { buffer.insert(0, char) }
        fun append(char: Char): DigitBuffer = also { buffer.append(char) }
        companion object {

            private val LITERAL_DIGIT_MAP: Map<String, Int> = mapOf(
                "one" to 1,
                "two" to 2,
                "three" to 3,
                "four" to 4,
                "five" to 5,
                "six" to 6,
                "seven" to 7,
                "eight" to 8,
                "nine" to 9
            )

        }
    }

}