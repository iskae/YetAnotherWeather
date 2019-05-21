package de.iskae.cache

import de.iskae.cache.db.WeatherDatabase
import de.iskae.cache.mapper.CachedWeatherMapper
import de.iskae.cache.model.Config
import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherCache
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherCacheImpl @Inject constructor(
    private val weatherDatabase: WeatherDatabase,
    private val cachedWeatherMapper: CachedWeatherMapper
) : WeatherCache {
    override fun clearCurrentWeather(): Completable {
        return Completable.defer {
            weatherDatabase.cachedWeatherDao().deleteAllWeather()
            Completable.complete()
        }
    }

    override fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable {
        return weatherDatabase.cachedWeatherDao().insertWeather(cachedWeatherMapper.mapToCached(weatherEntity))
    }

    override fun getCurrentWeather(id: Long): Observable<WeatherEntity> {
        return weatherDatabase.cachedWeatherDao().getWeatherById(id)
            .toObservable()
            .map {
                cachedWeatherMapper.mapFromCached(it)
            }
    }

    override fun isCurrentWeatherCached(id: Long): Single<Boolean> {
        return weatherDatabase.cachedWeatherDao().getWeatherById(id).isEmpty
            .map { !it }
    }

    override fun setLastCacheTime(id: Long, lastCache: Long): Completable {
        return weatherDatabase.configDao().insertConfig(Config(id, lastCache))
    }

    override fun isCurrentWeatherCacheExpired(id: Long): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val cacheExpirationTime = TimeUnit.HOURS.toMillis(3)
        return weatherDatabase.configDao().getConfig(id)
            .map { config ->
                currentTime - config.lastCacheTime > cacheExpirationTime
            }
    }

}