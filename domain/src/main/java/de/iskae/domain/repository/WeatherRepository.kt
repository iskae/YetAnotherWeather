package de.iskae.domain.repository

import de.iskae.domain.model.WeatherData
import io.reactivex.Observable

interface WeatherRepository {
  fun getCurrentWeather(coordinates: String): Observable<WeatherData>
  fun getHourlyForecast(coordinates: String): Observable<List<WeatherData>>
}