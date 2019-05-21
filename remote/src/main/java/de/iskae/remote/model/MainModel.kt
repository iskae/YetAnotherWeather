package de.iskae.remote.model

data class MainModel(
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val sea_level: Int,
    val ground_level: Int
)