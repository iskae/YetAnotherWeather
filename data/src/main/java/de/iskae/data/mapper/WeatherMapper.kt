package de.iskae.data.mapper

import de.iskae.data.model.WeatherEntity
import de.iskae.domain.model.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() : EntityMapper<WeatherEntity, Weather> {

  override fun mapFromEntity(entity: WeatherEntity): Weather {
    return Weather(
        id = entity.id,
        latitude = entity.latitude,
        longitude = entity.longitude,
        description = entity.description,
        iconId = entity.iconId,
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
        latitude = domain.latitude,
        longitude = domain.longitude,
        description = domain.description,
        iconId = domain.iconId,
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