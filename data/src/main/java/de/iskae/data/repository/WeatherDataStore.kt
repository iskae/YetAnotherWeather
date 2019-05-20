package de.iskae.data.repository

import de.iskae.data.model.WeatherEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface WeatherDataStore {
    fun getCurrentWeather(): Observable<WeatherEntity>
    fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable
    fun clearCurrentWeather(): Completable
}