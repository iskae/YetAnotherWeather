package de.iskae.presentation.model

data class WeatherPresentation(
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