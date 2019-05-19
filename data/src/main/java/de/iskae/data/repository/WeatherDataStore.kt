package de.iskae.data.repository

import de.iskae.data.model.WeatherDataEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface WeatherDataStore {
    fun getCurrentWeatherData(): Observable<WeatherDataEntity>
    fun saveCurrentWeatherData(weatherData: WeatherDataEntity): Completable
    fun clearCurrentWeatherData(): Completable
}