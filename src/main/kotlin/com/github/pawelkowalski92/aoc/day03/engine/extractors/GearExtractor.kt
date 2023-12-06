package com.github.pawelkowalski92.aoc.day03.engine.extractors

import com.github.pawelkowalski92.aoc.day03.engine.Gear
import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.createEnginePart
import com.github.pawelkowalski92.aoc.day03.engine.extractors.EnginePartExtractor.SchematicsContext
import com.github.pawelkowalski92.aoc.day03.engine.locators.PartLocator

class GearExtractor(
    private val gearPartLocator: PartLocator,
    private val numericPartLocator: PartLocator
) : EnginePartExtractor<Gear> {
    override fun extractPart(schematicsContext: SchematicsContext): List<Gear> =
        gearPartLocator.locateParts(schematicsContext.current)
            .mapNotNull { it.createGear(schematicsContext) }

    private fun PartLocation.createGear(schematicsContext: SchematicsContext): Gear? {
        val surroundingParts = mutableListOf<PartLocation>().apply {
            schematicsContext.previous?.let(numericPartLocator::locateParts)?.let(::addAll)
            schematicsContext.current.let(numericPartLocator::locateParts).let(::addAll)
            schematicsContext.next?.let(numericPartLocator::locateParts)?.let(::addAll)
        }
        return surroundingParts.filter { isAdjacentTo(it) }
            .takeIf { it.size == 2 }
            ?.map { it.createEnginePart() }
            ?.let(::Gear)
    }

    private fun PartLocation.isAdjacentTo(other: PartLocation): Boolean =
        location.first >= other.locationWithAdjacent.first && location.last <= other.locationWithAdjacent.last

}