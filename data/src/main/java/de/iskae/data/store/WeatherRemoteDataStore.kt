package de.iskae.data.store

import de.iskae.data.model.WeatherDataEntity
import de.iskae.data.repository.WeatherDataStore
import de.iskae.data.repository.WeatherRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRemoteDataStore @Inject constructor(private val weatherRemote: WeatherRemote) : WeatherDataStore {

    override fun getCurrentWeatherData(): Observable<WeatherDataEntity> {
        return weatherRemote.getCurrentWeatherData()
    }

    override fun saveCurrentWeatherData(weatherData: WeatherDataEntity): Completable {
        throw UnsupportedOperationException("Saving current weather data is not possible in remote store")
    }

    override fun clearCurrentWeatherData(): Completable {
        throw UnsupportedOperationException("Clearing current weather data is not possible in remote store")
    }
}