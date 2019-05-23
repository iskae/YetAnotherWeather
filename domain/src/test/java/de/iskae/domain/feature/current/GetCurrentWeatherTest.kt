package de.iskae.domain.feature.current

import com.nhaarman.mockitokotlin2.whenever
import de.iskae.domain.executor.PostExecutionThread
import de.iskae.domain.mock.DataFactory
import de.iskae.domain.mock.WeatherMockFactory
import de.iskae.domain.model.Weather
import de.iskae.domain.repository.WeatherRepository
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
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
      GetCurrentWeather.Params.forCity(
        DataFactory.randomString(),
        DataFactory.randomString()
      )
    ).test()
    testObserver.assertComplete()
  }

  @Test
  fun getCurrentWeatherHasData() {
    val currentWeatherData = WeatherMockFactory.mockWeather()
    stubGetCurrentWeather(Observable.just(currentWeatherData))
    val testObserver = getCurrentWeather.buildUseCaseObservable(
      GetCurrentWeather.Params.forCity(
        DataFactory.randomString(),
        DataFactory.randomString()
      )
    ).test()
    testObserver.assertValue(currentWeatherData)
  }

  @Test(expected = IllegalArgumentException::class)
  fun getCurrentWeatherThrowsException() {
    getCurrentWeather.buildUseCaseObservable().test()
  }

  private fun stubGetCurrentWeather(observable: Observable<Weather>) {
    whenever(weatherRepository.getCurrentWeatherByCityId(cityId = anyString(), unit = anyString()))
      .thenReturn(observable)
  }

}