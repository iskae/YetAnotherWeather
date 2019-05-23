package de.iskae.domain.mock

import de.iskae.domain.model.Weather

object WeatherMockFactory {

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
}