package de.iskae.data.repository

import de.iskae.data.model.WeatherEntity
import io.reactivex.Observable

interface WeatherRemote {
    fun getCurrentWeatherByCity(city: String, unit: String): Observable<WeatherEntity>
}