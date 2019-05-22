package de.iskae.presentation.factory

import de.iskae.domain.model.Weather
import de.iskae.presentation.model.WeatherView

object WeatherFactory {

  fun mockWeather(): Weather {
    return Weather(
        id = DataFactory.randomLong(),
        latitude = DataFactory.randomDouble(),
        longitude = DataFactory.randomDouble(),
        description = DataFactory.randomString(),
        iconId = DataFactory.randomInt(),
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
        latitude = DataFactory.randomDouble(),
        longitude = DataFactory.randomDouble(),
        description = DataFactory.randomString(),
        iconId = DataFactory.randomInt(),
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