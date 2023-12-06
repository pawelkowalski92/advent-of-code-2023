package com.github.pawelkowalski92.aoc.day03.engine

class EngineFactory {

    fun createEngine(input: Collection<String>): Engine = input.map(::SchematicsPart).let(::Engine)

}