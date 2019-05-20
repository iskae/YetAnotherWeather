package de.iskae.data.store

import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherCache
import de.iskae.data.repository.WeatherDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class WeatherCacheDataStore @Inject constructor(private val weatherCache: WeatherCache) : WeatherDataStore {

    override fun getCurrentWeather(): Observable<WeatherEntity> {
        return weatherCache.getCurrentWeather()
    }

    override fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable {
        return weatherCache.saveCurrentWeather(weatherEntity = weatherEntity)
            .andThen(weatherCache.setLastCacheTime(System.currentTimeMillis()))
    }

    override fun clearCurrentWeather(): Completable {
        return weatherCache.clearCurrentWeather()
    }
}