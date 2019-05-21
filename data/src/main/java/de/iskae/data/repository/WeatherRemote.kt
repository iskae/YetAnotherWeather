package de.iskae.data.repository

import de.iskae.data.model.WeatherEntity
import io.reactivex.Observable

interface WeatherRemote {
    fun getCurrentWeather(appId: String, city: String, unit: String): Observable<WeatherEntity>
}