package de.iskae.data

import de.iskae.data.mapper.WeatherDataMapper
import de.iskae.data.repository.WeatherCache
import de.iskae.data.store.WeatherDataStoreFactory
import de.iskae.domain.model.WeatherData
import de.iskae.domain.repository.WeatherRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class WeatherDataRepository @Inject constructor(
    private val weatherDataMapper: WeatherDataMapper,
    private val weatherCache: WeatherCache,
    private val weatherFactory: WeatherDataStoreFactory
) : WeatherRepository {

    override fun getCurrentWeather(coordinates: String): Observable<WeatherData> {
        return Observable.zip(weatherCache.isCurrentWeatherDataCached().toObservable(),
            weatherCache.isCurrentWeatherDataCacheExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                Pair(areCached, isExpired)
            })
            .flatMap {
                weatherFactory.getDataStore(it.first, it.second).getCurrentWeatherData()
            }
            .flatMap { currentWeatherData ->
                weatherFactory.getCacheDataStore()
                    .saveCurrentWeatherData(currentWeatherData)
                    .andThen(Observable.just(currentWeatherData))
            }
            .map {
                weatherDataMapper.mapFromEntity(it)
            }
    }

    override fun getHourlyForecast(coordinates: String): Observable<List<WeatherData>> {
        throw NotImplementedError("This feature will be implemented")
    }
}