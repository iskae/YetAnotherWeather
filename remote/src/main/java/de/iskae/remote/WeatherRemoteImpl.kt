package de.iskae.remote

import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherRemote
import de.iskae.remote.mapper.WeatherResponseModelMapper
import de.iskae.remote.service.OpenWeatherMapService
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRemoteImpl @Inject constructor(
    private val openWeatherMapService: OpenWeatherMapService,
    private val weatherResponseModelMapper: WeatherResponseModelMapper
) : WeatherRemote {
  override fun getCurrentWeatherByCity(city: String, unit: String): Observable<WeatherEntity> {
    return openWeatherMapService.getCurrentWeatherByCity(city, unit)
        .map { weatherResponseModel ->
          weatherResponseModelMapper.mapFromModel(weatherResponseModel)
        }
  }

}