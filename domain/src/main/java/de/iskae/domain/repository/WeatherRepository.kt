package de.iskae.domain.repository

import de.iskae.domain.model.Weather
import io.reactivex.Observable

interface WeatherRepository {
  fun getCurrentWeatherByCityId(cityId: String, unit: String): Observable<Weather>
  fun getHourlyForecastByCityId(cityId: String, unit: String): Observable<List<Weather>>
}