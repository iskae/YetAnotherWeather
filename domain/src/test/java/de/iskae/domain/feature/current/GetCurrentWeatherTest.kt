package de.iskae.domain.feature.current

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.domain.executor.PostExecutionThread
import de.iskae.domain.mock.DataFactory
import de.iskae.domain.mock.WeatherMockFactory
import de.iskae.domain.model.Weather
import de.iskae.domain.repository.WeatherRepository
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetCurrentWeatherTest {
    private lateinit var getCurrentWeather: GetCurrentWeather
    @Mock
    lateinit var weatherRepository: WeatherRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getCurrentWeather = GetCurrentWeather(weatherRepository, postExecutionThread)
    }

    @Test
    fun getCurrentWeatherCompletes() {
        stubGetCurrentWeather(Observable.just(WeatherMockFactory.mockWeather()))
        val testObserver = getCurrentWeather.buildUseCaseObservable(
            GetCurrentWeather.Params.forCoordinates(DataFactory.randomString())
        ).test()
        testObserver.assertComplete()
    }

    @Test
    fun getCurrentWeatherHasData() {
        val currentWeatherData = WeatherMockFactory.mockWeather()
        stubGetCurrentWeather(Observable.just(currentWeatherData))
        val testObserver = getCurrentWeather.buildUseCaseObservable(
            GetCurrentWeather.Params.forCoordinates(DataFactory.randomString())
        ).test()
        testObserver.assertValue(currentWeatherData)
    }

    @Test(expected = IllegalArgumentException::class)
    fun getCurrentWeatherThrowsException() {
        getCurrentWeather.buildUseCaseObservable().test()
    }

    private fun stubGetCurrentWeather(observable: Observable<Weather>) {
        whenever(weatherRepository.getCurrentWeather(coordinates = any()))
            .thenReturn(observable)
    }

}