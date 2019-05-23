package de.iskae.data.repository

import de.iskae.data.model.WeatherEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface WeatherCache {
  fun clearCurrentWeather(): Completable
  fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable
  fun getCurrentWeather(id: Long): Observable<WeatherEntity>
  fun isCurrentWeatherCached(id: Long): Single<Boolean>
  fun setLastCacheTime(id: Long, lastCache: Long): Completable
  fun isCurrentWeatherCacheExpired(id: Long): Single<Boolean>
}
