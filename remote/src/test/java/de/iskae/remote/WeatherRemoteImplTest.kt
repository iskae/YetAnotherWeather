package de.iskae.remote

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.model.WeatherEntity
import de.iskae.remote.factory.DataFactory
import de.iskae.remote.factory.WeatherDataFactory
import de.iskae.remote.mapper.WeatherResponseModelMapper
import de.iskae.remote.model.WeatherResponseModel
import de.iskae.remote.service.OpenWeatherMapService
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnit4::class)
class WeatherRemoteImplTest {

  private val service = mock<OpenWeatherMapService>()
  private val mapper = mock<WeatherResponseModelMapper>()
  private val weatherRemoteImpl = WeatherRemoteImpl(service, mapper)

  @Test
  fun getCurrentWeatherCompletes() {
    stubOwmServiceGetCurrentWeatherByCoordinates(Observable.just(WeatherDataFactory.mockWeatherResponseModel()))
    stubWeatherResponseModelMapperMapFromModel(any(), WeatherDataFactory.mockWeatherEntity())
    val testObserver = weatherRemoteImpl.getCurrentWeatherByCity(
        DataFactory.randomString(),
        DataFactory.randomString()
    ).test()
    testObserver.assertComplete()
  }

  @Test
  fun getCurrentWeatherCallsService() {
    stubOwmServiceGetCurrentWeatherByCoordinates(Observable.just(WeatherDataFactory.mockWeatherResponseModel()))
    stubWeatherResponseModelMapperMapFromModel(any(), WeatherDataFactory.mockWeatherEntity())
    weatherRemoteImpl.getCurrentWeatherByCity(
        DataFactory.randomString(),
        DataFactory.randomString()
    ).test()
    verify(service).getCurrentWeatherByCity(anyString(), anyString())
  }

  @Test
  fun getCurrentWeatherReturnsData() {
    val weatherResponseModel = WeatherDataFactory.mockWeatherResponseModel()
    stubOwmServiceGetCurrentWeatherByCoordinates(Observable.just(weatherResponseModel))
    val entity = WeatherDataFactory.mockWeatherEntity()
    stubWeatherResponseModelMapperMapFromModel(weatherResponseModel, entity)
    val testObserver = weatherRemoteImpl.getCurrentWeatherByCity(
        DataFactory.randomString(),
        DataFactory.randomString()
    ).test()
    testObserver.assertValue(entity)
  }

  private fun stubOwmServiceGetCurrentWeatherByCoordinates(observable: Observable<WeatherResponseModel>) {
    whenever(service.getCurrentWeatherByCity(anyString(), anyString()))
        .thenReturn(observable)
  }

  private fun stubWeatherResponseModelMapperMapFromModel(model: WeatherResponseModel, entity: WeatherEntity) {
    whenever(mapper.mapFromModel(model))
        .thenReturn(entity)
  }

}