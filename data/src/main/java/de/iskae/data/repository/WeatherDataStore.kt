package de.iskae.data.repository

import de.iskae.data.model.WeatherEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface WeatherDataStore {
    fun getCurrentWeatherByCity(city: String, unit: String): Observable<WeatherEntity>
    fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable
    fun clearCurrentWeather(): Completable
}