package de.iskae.ui.test.factory

import de.iskae.domain.model.Weather

object TestWeatherFactory {

  fun mockTestWeather(): Weather {
    return Weather(
      id = TestDataFactory.randomLong(),
      name = TestDataFactory.randomString(),
      latitude = TestDataFactory.randomDouble(),
      longitude = TestDataFactory.randomDouble(),
      description = TestDataFactory.randomString(),
      icon = TestDataFactory.randomString(),
      temperature = TestDataFactory.randomDouble(),
      pressure = TestDataFactory.randomInt(),
      tempMax = TestDataFactory.randomDouble(),
      tempMin = TestDataFactory.randomDouble(),
      windSpeed = TestDataFactory.randomDouble(),
      windDegree = TestDataFactory.randomInt(),
      cloudinessPercentage = TestDataFactory.randomInt(),
      sunrise = TestDataFactory.randomLong(),
      sunset = TestDataFactory.randomLong()
    )
  }
}