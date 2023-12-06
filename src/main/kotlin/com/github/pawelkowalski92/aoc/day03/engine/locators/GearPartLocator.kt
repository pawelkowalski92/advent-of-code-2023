package com.github.pawelkowalski92.aoc.day03.engine.locators

import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart

class GearPartLocator : PartLocator {

    override fun locateParts(schematicsPart: SchematicsPart): List<PartLocation> =
        mutableListOf<PartLocation>().apply {
            schematicsPart.content.forEachIndexed { ix, c ->
                if (c == '*')
                    PartLocation(
                        schematicsPart = schematicsPart,
                        location = ix
                    ).also(::add)
            }
        }

}