package de.iskae.data.factory

import de.iskae.data.model.*
import de.iskae.domain.model.*

object WeatherFactory {

    fun mockCloudsEntity(): CloudsEntity {
        return CloudsEntity(cloudinessPercentage = DataFactory.randomInt())
    }

    fun mockCoordEntity(): CoordEntity {
        return CoordEntity(lat = DataFactory.randomDouble(), lon = DataFactory.randomDouble())
    }

    fun mockMainEntity(): MainEntity {
        return MainEntity(
            humidity = DataFactory.randomInt(),
            pressure = DataFactory.randomInt(),
            temp = DataFactory.randomDouble(),
            tempMax = DataFactory.randomDouble(),
            tempMin = DataFactory.randomDouble()
        )
    }

    fun mockSysEntity(): SysEntity {
        return SysEntity(
            country = DataFactory.randomString(),
            sunrise = DataFactory.randomInt(),
            sunset = DataFactory.randomInt(),
            type = DataFactory.randomInt()
        )
    }

    fun mockWindEntity(): WindEntity {
        return WindEntity(
            deg = DataFactory.randomInt(),
            speed = DataFactory.randomDouble()
        )
    }

    fun mockWeatherEntity(): WeatherEntity {
        return WeatherEntity(
            id = DataFactory.randomInt(),
            main = DataFactory.randomString(),
            description = DataFactory.randomString(),
            iconId = DataFactory.randomInt()
        )
    }

    fun mockWeatherDataEntity(): WeatherDataEntity {
        val currentWeatherList = mutableListOf(mockWeatherEntity())
        return WeatherDataEntity(
            idEntity = DataFactory.randomInt(),
            cloudsEntity = mockCloudsEntity(),
            coordEntity = mockCoordEntity(),
            dtEntity = DataFactory.randomInt(),
            mainEntity = mockMainEntity(),
            nameEntity = DataFactory.randomString(),
            sysEntity = mockSysEntity(),
            weatherListEntity = currentWeatherList,
            windEntity = mockWindEntity()
        )
    }

    fun mockClouds(): Clouds {
        return Clouds(cloudinessPercentage = DataFactory.randomInt())
    }

    fun mockCoord(): Coord {
        return Coord(
            lat = DataFactory.randomDouble(),
            lon = DataFactory.randomDouble()
        )
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