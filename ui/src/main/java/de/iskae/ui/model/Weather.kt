package de.iskae.ui.model

class Weather(
    val id: Long,
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