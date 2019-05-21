package de.iskae.domain.feature.current

import de.iskae.domain.executor.PostExecutionThread
import de.iskae.domain.feature.ObservableUseCase
import de.iskae.domain.model.Weather
import de.iskae.domain.repository.WeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetCurrentWeather @Inject constructor(
    private val weatherRepository: WeatherRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<Weather, GetCurrentWeather.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<Weather> {
        if (params == null) throw IllegalArgumentException("Coordinates can't be null!")
        return weatherRepository.getCurrentWeather(params.apiKey, params.coordinates, params.unit)
    }

    data class Params constructor(val apiKey: String, val coordinates: String, val unit: String) {
        companion object {
            fun forCoordinates(apiKey: String, coordinates: String, unit: String): Params {
                return Params(apiKey, coordinates, unit)
            }
        }
    }
}