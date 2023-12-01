package com.github.pawelkowalski92.aoc.util

import java.io.BufferedReader

fun <T : Any> T.getResource(resource: String): BufferedReader =
    javaClass.classLoader.getResourceAsStream(resource)?.bufferedReader(Charsets.UTF_8)
        ?: throw IllegalArgumentException("Invalid resource path: $resource")

