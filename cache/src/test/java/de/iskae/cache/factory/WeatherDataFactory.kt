package de.iskae.cache.factory

import de.iskae.cache.model.CachedWeather
import de.iskae.data.model.WeatherEntity

object WeatherDataFactory {

  fun mockCachedWeather(): CachedWeather {
    return CachedWeather(
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

  fun mockWeatherEntity(): WeatherEntity {
    return WeatherEntity(
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