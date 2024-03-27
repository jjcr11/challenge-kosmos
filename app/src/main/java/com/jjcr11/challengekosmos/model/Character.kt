package com.jjcr11.challengekosmos.model

data class Character(
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location
)
