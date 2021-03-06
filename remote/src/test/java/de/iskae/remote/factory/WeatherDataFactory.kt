package de.iskae.remote.factory

import de.iskae.data.model.WeatherEntity
import de.iskae.remote.model.CloudsModel
import de.iskae.remote.model.CoordModel
import de.iskae.remote.model.MainModel
import de.iskae.remote.model.SysModel
import de.iskae.remote.model.WeatherModel
import de.iskae.remote.model.WeatherResponseModel
import de.iskae.remote.model.WindModel

object WeatherDataFactory {
  fun mockCloudsModel(): CloudsModel {
    return CloudsModel(all = DataFactory.randomInt())
  }

  fun mockCoordModel(): CoordModel {
    return CoordModel(lat = DataFactory.randomDouble(), lon = DataFactory.randomDouble())
  }

  fun mockMainModel(): MainModel {
    return MainModel(
      humidity = DataFactory.randomInt(),
      pressure = DataFactory.randomInt(),
      temp = DataFactory.randomDouble(),
      temp_max = DataFactory.randomDouble(),
      temp_min = DataFactory.randomDouble(),
      sea_level = DataFactory.randomInt(),
      ground_level = DataFactory.randomInt()
    )
  }

  fun mockSysModel(): SysModel {
    return SysModel(
      country = DataFactory.randomString(),
      sunrise = DataFactory.randomLong(),
      sunset = DataFactory.randomLong(),
      type = DataFactory.randomInt()
    )
  }

  fun mockWindModel(): WindModel {
    return WindModel(
      deg = DataFactory.randomInt(),
      speed = DataFactory.randomDouble()
    )
  }

  fun mockWeatherModel(): WeatherModel {
    return WeatherModel(
      id = DataFactory.randomInt(),
      main = DataFactory.randomString(),
      description = DataFactory.randomString(),
      icon = DataFactory.randomString()
    )
  }

  fun mockWeatherResponseModel(): WeatherResponseModel {
    val currentWeatherList = mutableListOf(mockWeatherModel())
    return WeatherResponseModel(
      id = DataFactory.randomLong(),
      clouds = mockCloudsModel(),
      coord = mockCoordModel(),
      dt = DataFactory.randomLong(),
      main = mockMainModel(),
      name = DataFactory.randomString(),
      sys = mockSysModel(),
      weather = currentWeatherList,
      wind = mockWindModel(),
      visibility = DataFactory.randomInt()
    )
  }

  fun mockWeatherEntity(): WeatherEntity {
    return WeatherEntity(
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