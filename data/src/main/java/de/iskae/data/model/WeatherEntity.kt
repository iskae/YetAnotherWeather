package de.iskae.data.model

data class WeatherEntity(
    val id: Int,
    val main: String,
    val description: String,
    val iconId: Int
)