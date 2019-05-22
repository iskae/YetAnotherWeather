package de.iskae.presentation.mapper

import de.iskae.domain.model.Weather
import de.iskae.presentation.model.WeatherView
import javax.inject.Inject

class WeatherViewMapper @Inject constructor() : PresentationMapper<Weather, WeatherView> {
  override fun mapToView(domain: Weather): WeatherView {
    return WeatherView(
        id = domain.id,
        latitude = domain.latitude,
        longitude = domain.longitude,
        description = domain.description,
        iconId = domain.iconId,
        temperature = domain.temperature,
        pressure = domain.pressure,
        tempMax = domain.tempMax,
        tempMin = domain.tempMin,
        windSpeed = domain.windSpeed,
        windDegree = domain.windDegree,
        cloudinessPercentage = domain.cloudinessPercentage,
        sunrise = domain.sunrise,
        sunset = domain.sunset
    )
  }
}