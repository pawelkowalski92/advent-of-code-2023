package com.github.pawelkowalski92.aoc.day03.engine

data class PartLocation(
    val schematicsPart: SchematicsPart,
    val location: IntRange,
) {
    constructor(schematicsPart: SchematicsPart, location: Int) : this(schematicsPart, location..location)

    val locationWithAdjacent: IntRange
        get() = location.first - 1 .. location.last + 1

    val value: String
        get() = schematicsPart.content(location)
}

fun PartLocation.createEnginePart(): EnginePart = value.toInt().let(::EnginePart)

data class EnginePart(val value: Int)

data class Gear(val adjacentParts: List<EnginePart>) {
    val ratio: Int
        get() = adjacentParts.map(EnginePart::value).reduce(Int::times)

}