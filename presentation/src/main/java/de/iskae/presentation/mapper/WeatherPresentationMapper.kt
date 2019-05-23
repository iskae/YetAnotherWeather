package de.iskae.presentation.mapper

import de.iskae.domain.model.Weather
import de.iskae.presentation.model.WeatherPresentation
import javax.inject.Inject

class WeatherPresentationMapper @Inject constructor() : PresentationMapper<Weather, WeatherPresentation> {
  override fun mapToView(domain: Weather): WeatherPresentation {
    return WeatherPresentation(
      id = domain.id,
      name = domain.name,
      latitude = domain.latitude,
      longitude = domain.longitude,
      description = domain.description,
      icon = domain.icon,
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