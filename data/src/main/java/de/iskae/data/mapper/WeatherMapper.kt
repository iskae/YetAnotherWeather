package de.iskae.data.mapper

import de.iskae.data.model.WeatherEntity
import de.iskae.domain.model.Weather

class WeatherMapper : EntityMapper<WeatherEntity, Weather> {

  override fun mapFromEntity(entity: WeatherEntity): Weather {
    return Weather(
      id = entity.id,
      name = entity.name,
      latitude = entity.latitude,
      longitude = entity.longitude,
      description = entity.description,
      icon = entity.icon,
      temperature = entity.temperature,
      pressure = entity.pressure,
      tempMax = entity.tempMax,
      tempMin = entity.tempMin,
      windSpeed = entity.windSpeed,
      windDegree = entity.windDegree,
      cloudinessPercentage = entity.cloudinessPercentage,
      sunrise = entity.sunrise,
      sunset = entity.sunset
    )
  }

  override fun mapToEntity(domain: Weather): WeatherEntity {
    return WeatherEntity(
      id = domain.id,
      name = domain.name,
      latitude = domain.latitude,
      longitude = domain.longitude,
      description = domain.description,
      icon = domain.icon,
      temperature = domain.temperature,
      pressure = domain.pressure,
      tempMax = domain.tempMax,
      tempMin = domain.tempMin,
      windSpeed = domain.windSpeed,
      windDegree = domain.windDegree,
      cloudinessPercentage = domain.cloudinessPercentage,
      sunrise = domain.sunrise,
      sunset = domain.sunset
    )
  }
}