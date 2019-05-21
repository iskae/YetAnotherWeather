package de.iskae.data.repository

import de.iskae.data.model.WeatherEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface WeatherCache {
    fun clearCurrentWeather(): Completable
    fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable
    fun getCurrentWeather(): Observable<WeatherEntity>
    fun isCurrentWeatherCached(): Single<Boolean>
    fun setLastCacheTime(lastCache: Long): Completable
    fun isCurrentWeatherCacheExpired(): Single<Boolean>
}
