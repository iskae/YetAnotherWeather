package de.iskae.data.store

import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherDataStore
import de.iskae.data.repository.WeatherRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRemoteDataStore @Inject constructor(private val weatherRemote: WeatherRemote) : WeatherDataStore {

  override fun getCurrentWeatherByCity(city: String, unit: String): Observable<WeatherEntity> {
    return weatherRemote.getCurrentWeatherByCity(city, unit)
  }

  override fun saveCurrentWeather(weatherEntity: WeatherEntity): Completable {
    throw UnsupportedOperationException("Saving current weather data is not possible in remote store")
  }

  override fun clearCurrentWeather(): Completable {
    throw UnsupportedOperationException("Clearing current weather data is not possible in remote store")
  }
}