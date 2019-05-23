package de.iskae.ui.mapper

import de.iskae.presentation.model.WeatherPresentation
import de.iskae.ui.model.WeatherView

class WeatherViewMapper : ViewMapper<WeatherPresentation, WeatherView> {
  override fun mapToView(presentation: WeatherPresentation): WeatherView {
    return WeatherView(
      id = presentation.id,
      name = presentation.name,
      latitude = presentation.latitude,
      longitude = presentation.longitude,
      description = presentation.description,
      icon = presentation.icon,
      temperature = presentation.temperature.toString(),
      pressure = presentation.pressure.toString(),
      tempMax = presentation.tempMax.toString(),
      tempMin = presentation.tempMin.toString(),
      windSpeed = presentation.windSpeed.toString(),
      windDegree = presentation.windDegree.toString(),
      cloudinessPercentage = presentation.cloudinessPercentage.toString(),
      sunrise = presentation.sunrise.toString(),
      sunset = presentation.sunset.toString()
    )
  }
}