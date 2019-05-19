package de.iskae.domain.model

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val iconId: Int
)