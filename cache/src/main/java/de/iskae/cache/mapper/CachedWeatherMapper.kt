package de.iskae.cache.mapper

import de.iskae.cache.model.CachedWeather
import de.iskae.data.model.WeatherEntity

class CachedWeatherMapper : CacheMapper<CachedWeather, WeatherEntity> {
    override fun mapFromCached(cache: CachedWeather): WeatherEntity {
        return WeatherEntity(
            id = cache.id,
            latitude = cache.latitude,
            longitude = cache.longitude,
            description = cache.description,
            iconId = cache.iconId,
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

}