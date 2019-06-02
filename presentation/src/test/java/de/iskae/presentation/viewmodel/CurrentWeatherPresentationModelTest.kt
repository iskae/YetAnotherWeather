package de.iskae.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.domain.feature.current.GetCurrentWeather
import de.iskae.domain.model.Weather
import de.iskae.presentation.factory.DataFactory
import de.iskae.presentation.factory.WeatherFactory
import de.iskae.presentation.mapper.WeatherViewMapper
import de.iskae.presentation.model.WeatherView
import de.iskae.presentation.state.Resource
import io.reactivex.observers.DisposableObserver
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

@RunWith(JUnit4::class)
class CurrentWeatherPresentationModelTest {

  @Rule
  @JvmField
  var instantTaskExecutorRule = InstantTaskExecutorRule()
  private var getCurrentWeather = mock<GetCurrentWeather>()
  private var mapper = mock<WeatherViewMapper>()
  private var currentWeatherViewModel = CurrentWeatherViewModel(getCurrentWeather, mapper)

  @Captor
  val captor = argumentCaptor<DisposableObserver<Weather>>()

  @Test
  fun setCityIdExecutesUseCase() {
    val params = GetCurrentWeather.Params(DataFactory.randomString())
    currentWeatherViewModel.setCityId(params.cityId)

    verify(getCurrentWeather, times(1)).execute(any(), eq(params))
  }

  @Test
  fun setCityIdReturnsData() {
    val weather = WeatherFactory.mockWeather()
    val weatherView = WeatherFactory.mockWeatherView()
    stubWeatherMapperMapToView(weatherView, weather)

    val params = GetCurrentWeather.Params(weather.id.toString())
    currentWeatherViewModel.setCityId(params.cityId)

    verify(getCurrentWeather).execute(captor.capture(), eq(params))
    captor.firstValue.onNext(weather)
    assertThat(Resource.Success(weatherView)).isEqualTo(currentWeatherViewModel.getCurrentWeather().value)
  }

  @Test
  fun fetchProjectsReturnsError() {
    val params = GetCurrentWeather.Params(DataFactory.randomString())
    currentWeatherViewModel.setCityId(params.cityId)

    verify(getCurrentWeather).execute(captor.capture(), eq(params))
    val throwable = Throwable()
    captor.firstValue.onError(throwable)
    assertThat(Resource.Error<WeatherView>(throwable)).isEqualTo(currentWeatherViewModel.getCurrentWeather().value)
  }

  private fun stubWeatherMapperMapToView(weatherView: WeatherView, weather: Weather) {
    whenever(mapper.mapToView(weather))
      .thenReturn(weatherView)
  }
}