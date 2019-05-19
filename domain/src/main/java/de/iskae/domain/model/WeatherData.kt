package de.iskae.domain.model

class WeatherData(
    val clouds: Clouds,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val weatherList: List<Weather>,
    val wind: Wind
)