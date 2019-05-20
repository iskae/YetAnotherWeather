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
        return weatherRepository.getCurrentWeather(params.coordinates)
    }

    data class Params constructor(val coordinates: String) {
        companion object {
            fun forCoordinates(coordinates: String): Params {
                return Params(coordinates)
            }
        }
    }
}