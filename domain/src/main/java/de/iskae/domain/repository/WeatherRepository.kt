package de.iskae.domain.repository

import de.iskae.domain.model.Weather
import io.reactivex.Observable

interface WeatherRepository {
    fun getCurrentWeather(coordinates: String): Observable<Weather>
    fun getHourlyForecast(coordinates: String): Observable<List<Weather>>
}