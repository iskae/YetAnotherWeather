package de.iskae.cache.mapper

import de.iskae.cache.model.CachedWeather
import de.iskae.data.model.WeatherEntity
import javax.inject.Inject

class CachedWeatherMapper @Inject constructor() : CacheMapper<CachedWeather, WeatherEntity> {
  override fun mapFromCached(cache: CachedWeather): WeatherEntity {
    return WeatherEntity(
      id = cache.id,
      name = cache.name,
      latitude = cache.latitude,
      longitude = cache.longitude,
      description = cache.description,
      icon = cache.icon,
      temperature = cache.temperature,
      pressure = cache.pressure,
      tempMax = cache.tempMax,
      tempMin = cache.tempMin,
      windSpeed = cache.windSpeed,
      windDegree = cache.windDegree,
      cloudinessPercentage = cache.cloudinessPercentage,
      sunrise = cache.sunrise,
      sunset = cache.sunset
    )
  }

  override fun mapToCached(entity: WeatherEntity): CachedWeather {
    return CachedWeather(
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

}