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

    override fun getCurrentWeather(apiKey: String, coordinates: String, unit: String): Observable<Weather> {
        return Observable.zip(weatherCache.isCurrentWeatherCached().toObservable(),
            weatherCache.isCurrentWeatherCacheExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                Pair(areCached, isExpired)
            })
            .flatMap {
                weatherFactory.getDataStore(it.first, it.second)
                    .getCurrentWeather(apiKey = apiKey, coordinates = coordinates, unit = unit)
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

    override fun getHourlyForecast(apiKey: String, coordinates: String, unit: String): Observable<List<Weather>> {
        throw NotImplementedError("This feature will be implemented")
    }
}