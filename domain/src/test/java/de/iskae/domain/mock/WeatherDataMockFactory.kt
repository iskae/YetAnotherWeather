package de.iskae.domain.mock

import de.iskae.domain.model.Clouds
import de.iskae.domain.model.Coord
import de.iskae.domain.model.Main
import de.iskae.domain.model.Sys
import de.iskae.domain.model.Weather
import de.iskae.domain.model.WeatherData
import de.iskae.domain.model.Wind
import java.util.UUID
import kotlin.random.Random

object WeatherDataMockFactory {

  fun randomUuid(): String {
    return UUID.randomUUID().toString()
  }

  fun randomInt(): Int {
    return Random.nextInt()
  }

  fun randomDouble(): Double {
    return Random.nextDouble()
  }

  fun mockClouds(): Clouds {
    return Clouds(cloudinessPercentage = randomInt())
  }

  fun mockCoord(): Coord {
    return Coord(lat = randomDouble(), lon = randomDouble())
  }

  fun mockMain(): Main {
    return Main(
        humidity = randomInt(),
        pressure = randomInt(),
        temp = randomDouble(),
        tempMax = randomDouble(),
        tempMin = randomDouble()
    )
  }

  fun mockSys(): Sys {
    return Sys(
        country = randomUuid(),
        sunrise = randomInt(),
        sunset = randomInt(),
        type = randomInt()
    )
  }

  fun mockWind(): Wind {
    return Wind(
        deg = randomInt(),
        speed = randomDouble()
    )
  }

  fun mockWeather(): Weather {
    return Weather(
        id = randomInt(),
        main = randomUuid(),
        description = randomUuid(),
        iconId = randomInt()
    )
  }

  fun mockWeatherData(): WeatherData {
    val currentWeatherList = mutableListOf(mockWeather())
    return WeatherData(
        id = randomInt(),
        clouds = mockClouds(),
        coord = mockCoord(),
        dt = randomInt(),
        main = mockMain(),
        name = randomUuid(),
        sys = mockSys(),
        weatherList = currentWeatherList,
        wind = mockWind()
    )
  }
}