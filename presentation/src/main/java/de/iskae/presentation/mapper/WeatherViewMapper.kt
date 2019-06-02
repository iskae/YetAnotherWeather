package de.iskae.presentation.mapper

import de.iskae.domain.model.Weather
import de.iskae.presentation.model.WeatherView
import javax.inject.Inject

class WeatherViewMapper @Inject constructor() : ViewMapper<Weather, WeatherView> {
  override fun mapToView(domain: Weather): WeatherView {
    return WeatherView(
      id = domain.id,
      name = domain.name,
      latitude = domain.latitude,
      longitude = domain.longitude,
      description = domain.description,
      icon = domain.icon,
      temperature = domain.temperature.toString(),
      pressure = domain.pressure.toString(),
      tempMax = domain.tempMax.toString(),
      tempMin = domain.tempMin.toString(),
      windSpeed = domain.windSpeed.toString(),
      windDegree = domain.windDegree.toString(),
      cloudinessPercentage = domain.cloudinessPercentage.toString(),
      sunrise = domain.sunrise.toString(),
      sunset = domain.sunset.toString()
    )
  }
}