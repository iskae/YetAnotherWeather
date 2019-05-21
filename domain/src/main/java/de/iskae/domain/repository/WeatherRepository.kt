package de.iskae.domain.repository

import de.iskae.domain.model.Weather
import io.reactivex.Observable

interface WeatherRepository {
    fun getCurrentWeather(apiKey: String, coordinates: String, unit: String): Observable<Weather>
    fun getHourlyForecast(apiKey: String, coordinates: String, unit: String): Observable<List<Weather>>
}