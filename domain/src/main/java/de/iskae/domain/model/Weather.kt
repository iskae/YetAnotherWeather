package de.iskae.domain.model

data class Weather(
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val iconId: Int,
    val temperature: Double,
    val pressure: Int,
    val tempMin: Double,
    val tempMax: Double,
    val windSpeed: Double,
    val windDegree: Int,
    val cloudinessPercentage: Int,
    val sunrise: Long,
    val sunset: Long
)