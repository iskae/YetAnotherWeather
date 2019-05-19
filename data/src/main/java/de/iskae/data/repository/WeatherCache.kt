package de.iskae.data.repository

import de.iskae.data.model.WeatherDataEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface WeatherCache {
    fun clearCurrentWeatherData(): Completable
    fun saveCurrentWeatherData(weatherDataEntity: WeatherDataEntity): Completable
    fun getCurrentWeatherData(): Observable<WeatherDataEntity>
    fun isCurrentWeatherDataCached(): Single<Boolean>
    fun setLastCacheTime(lastCache: Long): Completable
    fun isCurrentWeatherDataCacheExpired(): Single<Boolean>
}
