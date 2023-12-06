package com.github.pawelkowalski92.aoc.day03.engine.locators

import com.github.pawelkowalski92.aoc.day03.engine.PartLocation
import com.github.pawelkowalski92.aoc.day03.engine.SchematicsPart

fun interface PartLocator {

    fun locateParts(schematicsPart: SchematicsPart): List<PartLocation>

}