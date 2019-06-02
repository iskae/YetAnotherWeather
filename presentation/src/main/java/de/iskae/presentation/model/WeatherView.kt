package de.iskae.presentation.model

data class WeatherView(
  val id: Long,
  val name: String,
  val latitude: Double,
  val longitude: Double,
  val description: String,
  val icon: String,
  val temperature: String,
  val pressure: String,
  val tempMin: String,
  val tempMax: String,
  val windSpeed: String,
  val windDegree: String,
  val cloudinessPercentage: String,
  val sunrise: String,
  val sunset: String
)