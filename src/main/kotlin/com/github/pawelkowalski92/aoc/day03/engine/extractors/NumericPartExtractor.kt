package com.github.pawelkowalski92.aoc.day03.engine.extractors

import com.github.pawelkowalski92.aoc.day03.engine.EnginePart
import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.createEnginePart
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor.SchematicsContext
import com.github.pawelkowalski92.aoc.day03.engine.locators.PartLocator

class NumericPartExtractor(
    private val numericPartLocator: PartLocator
) : EnginePartExtractor<EnginePart> {
    override fun extractPart(schematicsContext: SchematicsContext): List<EnginePart> =
        numericPartLocator.locateParts(schematicsContext.current).filter { it.isAdjacentToSymbol(schematicsContext) }
            .map { it.createEnginePart() }

    private fun PartLocation.isAdjacentToSymbol(schematicsContext: SchematicsContext): Boolean {
        val surroundingChars = StringBuilder().apply {
            schematicsContext.previous?.content(locationWithAdjacent)?.let(::append)
            schematicsContext.current.content(locationWithAdjacent.first)?.let(::append)
            schematicsContext.current.content(locationWithAdjacent.last)?.let(::append)
            schematicsContext.next?.content(locationWithAdjacent)?.let(::append)
        }
        return surroundingChars.any { it.isSymbol() }
    }
    private fun Char.isSymbol(): Boolean = (isLetterOrDigit() || isWhitespace() || this == '.').not()

}