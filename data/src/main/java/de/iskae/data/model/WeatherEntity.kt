package de.iskae.data.model

data class WeatherEntity(
  val id: Long,
  val name: String,
  val latitude: Double,
  val longitude: Double,
  val description: String,
  val icon: String,
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