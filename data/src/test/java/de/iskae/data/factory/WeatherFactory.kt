package de.iskae.data.factory

import de.iskae.data.model.WeatherEntity
import de.iskae.domain.model.Weather

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