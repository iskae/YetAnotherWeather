package de.iskae.data.store

import de.iskae.data.model.WeatherDataEntity
import de.iskae.data.repository.WeatherCache
import de.iskae.data.repository.WeatherDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class WeatherCacheDataStore @Inject constructor(private val weatherCache: WeatherCache) : WeatherDataStore {

    override fun getCurrentWeatherData(): Observable<WeatherDataEntity> {
        return weatherCache.getCurrentWeatherData()
    }

    override fun saveCurrentWeatherData(weatherData: WeatherDataEntity): Completable {
        return weatherCache.saveCurrentWeatherData(weatherDataEntity = weatherData)
            .andThen(weatherCache.setLastCacheTime(System.currentTimeMillis()))
    }

    override fun clearCurrentWeatherData(): Completable {
        return weatherCache.clearCurrentWeatherData()
    }
}