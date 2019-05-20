package de.iskae.domain.mock

import de.iskae.domain.model.*

object WeatherDataMockFactory {

    fun mockClouds(): Clouds {
        return Clouds(cloudinessPercentage = DataFactory.randomInt())
    }

    fun mockCoord(): Coord {
        return Coord(lat = DataFactory.randomDouble(), lon = DataFactory.randomDouble())
    }

    fun mockMain(): Main {
        return Main(
            humidity = DataFactory.randomInt(),
            pressure = DataFactory.randomInt(),
            temp = DataFactory.randomDouble(),
            tempMax = DataFactory.randomDouble(),
            tempMin = DataFactory.randomDouble()
        )
    }

    fun mockSys(): Sys {
        return Sys(
            country = DataFactory.randomString(),
            sunrise = DataFactory.randomInt(),
            sunset = DataFactory.randomInt(),
            type = DataFactory.randomInt()
        )
    }

    fun mockWind(): Wind {
        return Wind(
            deg = DataFactory.randomInt(),
            speed = DataFactory.randomDouble()
        )
    }

    fun mockWeather(): Weather {
        return Weather(
            id = DataFactory.randomInt(),
            main = DataFactory.randomString(),
            description = DataFactory.randomString(),
            iconId = DataFactory.randomInt()
        )
    }

    fun mockWeatherData(): WeatherData {
        val currentWeatherList = mutableListOf(mockWeather())
        return WeatherData(
            id = DataFactory.randomInt(),
            clouds = mockClouds(),
            coord = mockCoord(),
            dt = DataFactory.randomInt(),
            main = mockMain(),
            name = DataFactory.randomString(),
            sys = mockSys(),
            weatherList = currentWeatherList,
            wind = mockWind()
        )
    }
}