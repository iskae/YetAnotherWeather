package de.iskae.remote.model

data class WeatherModel(
  val id: Int,
  val main: String,
  val description: String,
  val icon: String
)