package com.github.pawelkowalski92.aoc.day03.engine

class SchematicsPart(
    val content: String
) {
    fun content(range: IntRange): String {
        val start = range.first.takeUnless { it < 0 } ?: 0
        val end = range.last.takeIf { it < content.length } ?: (content.length - 1)
        return content.substring(start.. end)
    }

    fun content(index: Int): Char? = index.takeIf { it in content.indices }?.let(content::get)

}