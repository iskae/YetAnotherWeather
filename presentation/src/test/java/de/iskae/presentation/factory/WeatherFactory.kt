package de.iskae.presentation.factory

import de.iskae.domain.model.Weather
import de.iskae.presentation.model.WeatherPresentation

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

  fun mockWeatherView(): WeatherPresentation {
    return WeatherPresentation(
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
}