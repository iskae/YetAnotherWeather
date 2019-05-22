package de.iskae.data

import de.iskae.data.mapper.WeatherMapper
import de.iskae.data.repository.WeatherCache
import de.iskae.data.store.WeatherDataStoreFactory
import de.iskae.domain.model.Weather
import de.iskae.domain.repository.WeatherRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class WeatherDataRepository @Inject constructor(
    private val weatherMapper: WeatherMapper,
    private val weatherCache: WeatherCache,
    private val weatherFactory: WeatherDataStoreFactory
) : WeatherRepository {

  override fun getCurrentWeatherByCity(city: String, unit: String): Observable<Weather> {
    //TODO: Find city id from city name and pass it through
    return Observable.zip(weatherCache.isCurrentWeatherCached(0L).toObservable(),
        weatherCache.isCurrentWeatherCacheExpired(0L).toObservable(),
        BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
          Pair(areCached, isExpired)
        })
        .flatMap {
          weatherFactory.getDataStore(it.first, it.second)
              .getCurrentWeatherByCity(city = city, unit = unit)
        }
        .flatMap { currentWeatherData ->
          weatherFactory.getCacheDataStore()
              .saveCurrentWeather(currentWeatherData)
              .andThen(Observable.just(currentWeatherData))
        }
        .map {
          weatherMapper.mapFromEntity(it)
        }
  }

  override fun getHourlyForecastByCity(city: String, unit: String): Observable<List<Weather>> {
    throw NotImplementedError("This feature will be implemented")
  }
}