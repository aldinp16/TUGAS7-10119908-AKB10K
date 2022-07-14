package dev.aldi.a10119908latihan7

import dev.aldi.a10119908latihan7.model.People

data class SwapiResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<People>
)
