package de.iskae.domain.repository

import de.iskae.domain.model.Weather
import io.reactivex.Observable

interface WeatherRepository {
  fun getCurrentWeatherByCity(city: String, unit: String): Observable<Weather>
  fun getHourlyForecastByCity(city: String, unit: String): Observable<List<Weather>>
}