package de.iskae.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.DataFactory
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.mapper.WeatherMapper
import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherCache
import de.iskae.data.repository.WeatherDataStore
import de.iskae.data.store.WeatherDataStoreFactory
import de.iskae.domain.model.Weather
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnit4::class)
class WeatherDataRepositoryTest {
  private val mapper = mock<WeatherMapper>()
  private val factory = mock<WeatherDataStoreFactory>()
  private val store = mock<WeatherDataStore>()
  private val cache = mock<WeatherCache>()
  private val repository = WeatherDataRepository(mapper, cache, factory)

  @Before
  fun setup() {
    stubFactoryGetDataStore()
    stubFactoryGetCacheDataStore()
    stubIsCurrentWeatherDataCacheExpired(Single.just(false))
    stubIsCurrentWeatherDataCached(Single.just(false))
    stubSaveCurrentWeatherData(Completable.complete())
  }

  @Test
  fun getCurrentWeatherDataCompletes() {
    stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherEntity()))
    stubMapper(WeatherFactory.mockWeather(), any())

    val testObserver = repository.getCurrentWeatherByCityId(
        DataFactory.randomString(),
        DataFactory.randomString()
    ).test()
    testObserver.assertComplete()
  }

  @Test
  fun getCurrentWeatherDataReturnsData() {
    val weatherDataEntity = WeatherFactory.mockWeatherEntity()
    val weatherData = WeatherFactory.mockWeather()
    stubGetCurrentWeatherData(Observable.just(weatherDataEntity))
    stubMapper(weatherData, weatherDataEntity)

    val testObserver = repository.getCurrentWeatherByCityId(
        DataFactory.randomString(),
        DataFactory.randomString()
    ).test()
    testObserver.assertValue(weatherData)
  }

  private fun stubIsCurrentWeatherDataCacheExpired(single: Single<Boolean>) {
    whenever(cache.isCurrentWeatherCacheExpired(any()))
        .thenReturn(single)
  }

  private fun stubIsCurrentWeatherDataCached(single: Single<Boolean>) {
    whenever(cache.isCurrentWeatherCached(any()))
        .thenReturn(single)
  }

  private fun stubMapper(model: Weather, entity: WeatherEntity) {
    whenever(mapper.mapFromEntity(entity))
        .thenReturn(model)
  }

  private fun stubGetCurrentWeatherData(observable: Observable<WeatherEntity>) {
    whenever(store.getCurrentWeatherByCity(anyString(), anyString()))
        .thenReturn(observable)
  }

  private fun stubFactoryGetDataStore() {
    whenever(factory.getDataStore(anyBoolean(), anyBoolean()))
        .thenReturn(store)
  }

  private fun stubFactoryGetCacheDataStore() {
    whenever(factory.getCacheDataStore())
        .thenReturn(store)
  }

  private fun stubSaveCurrentWeatherData(completable: Completable) {
    whenever(store.saveCurrentWeather(any()))
        .thenReturn(completable)
  }
}