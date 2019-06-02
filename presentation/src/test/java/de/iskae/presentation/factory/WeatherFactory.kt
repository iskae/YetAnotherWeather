package de.iskae.presentation.factory

import de.iskae.domain.model.Weather
import de.iskae.presentation.model.WeatherView

object WeatherFactory {

  fun mockWeather(): Weather {
    return Weather(
      id = DataFactory.randomLong(),
      name = DataFactory.randomString(),
      latitude = DataFactory.randomDouble(),
      longitude = DataFactory.randomDouble(),
      description = DataFactory.randomString(),
      icon = DataFactory.randomString(),
      temperature = DataFactory.randomDouble(),
      pressure = DataFactory.randomInt(),
      tempMax = DataFactory.randomDouble(),
      tempMin = DataFactory.randomDouble(),
      windSpeed = DataFactory.randomDouble(),
      windDegree = DataFactory.randomInt(),
      cloudinessPercentage = DataFactory.randomInt(),
      sunrise = DataFactory.randomLong(),
      sunset = DataFactory.randomLong()
    )
  }

  fun mockWeatherView(): WeatherView {
    return WeatherView(
      id = DataFactory.randomLong(),
      name = DataFactory.randomString(),
      latitude = DataFactory.randomDouble(),
      longitude = DataFactory.randomDouble(),
      description = DataFactory.randomString(),
      icon = DataFactory.randomString(),
      temperature = DataFactory.randomString(),
      pressure = DataFactory.randomString(),
      tempMax = DataFactory.randomString(),
      tempMin = DataFactory.randomString(),
      windSpeed = DataFactory.randomString(),
      windDegree = DataFactory.randomString(),
      cloudinessPercentage = DataFactory.randomString(),
      sunrise = DataFactory.randomString(),
      sunset = DataFactory.randomString()
    )
  }
}