package com.github.pawelkowalski92.aoc.day05.garden

import com.github.pawelkowalski92.aoc.day05.garden.Instructions.InstructionsEntry

class AlmanacParser {

    fun parseAlmanach(input: Collection<String>): Almanac {
        val builder = InstructionsBuilder()
        val instructionsMap = mutableMapOf<String, Instructions>().apply {
            prepareInput(input).forEach { line ->
                if (line.contains("map")) {
                    builder.buildInstructions()?.also { put(it) }
                    parseLabel(line).also(builder::registerInstruction)
                } else {
                    parseInstructionEntry(line).also(builder::addInstructionEntry)
                }
            }
            builder.buildInstructions()?.also { put(it) }
        }
        return Almanac(
            seedToSoil = instructionsMap["seed-to-soil"]!!,
            soilToFertilizer = instructionsMap["soil-to-fertilizer"]!!,
            fertilizerToWater = instructionsMap["fertilizer-to-water"]!!,
            waterToLight = instructionsMap["water-to-light"]!!,
            lightToTemperature = instructionsMap["light-to-temperature"]!!,
            temperatureToHumidity = instructionsMap["temperature-to-humidity"]!!,
            humidityToLocation = instructionsMap["humidity-to-location"]!!
        )

    }

    private fun <K, V> MutableMap<in K, in V>.put(pair: Pair<K, V>) {
        put(pair.first, pair.second)
    }

    private fun prepareInput(input: Collection<String>): List<String> = input.toList().subList(1, input.size)
        .filter(String::isNotEmpty)

    private fun parseLabel(input: String): String = input.split(' ')[0]

    private fun parseInstructionEntry(input: String): InstructionsEntry = input.split(' ')
        .map(String::toLong).let {
            InstructionsEntry(
                source = it[1],
                destination = it[0],
                range = it[2]
            )
        }

    class InstructionsBuilder(
        private var label: String? = null,
        private var entries: MutableList<InstructionsEntry> = mutableListOf(),
    ) {

        fun registerInstruction(label: String) {
            this.label = label
        }

        fun addInstructionEntry(entry: InstructionsEntry) {
            entries.add(entry)
        }

        fun buildInstructions(): Pair<String, Instructions>? = label?.let { it to Instructions(entries.toList()) }
            ?.also { clear() }

        private fun clear() {
            label = null
            entries.clear()
        }

    }

}