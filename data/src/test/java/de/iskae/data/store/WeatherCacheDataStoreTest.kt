package de.iskae.data.store

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.DataFactory
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherCache
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyLong

@RunWith(JUnit4::class)
class WeatherCacheDataStoreTest {

  private val weatherCache = mock<WeatherCache>()
  private val weatherDataStore = WeatherCacheDataStore(weatherCache)

  @Test
  fun getCurrentWeatherDataCompletes() {
    stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherEntity()))
    val testObserver = weatherDataStore.getCurrentWeatherByCity(
      DataFactory.randomString(),
      DataFactory.randomString()
    ).test()
    testObserver.assertComplete()
  }

  @Test
  fun getCurrentWeatherDataReturnsData() {
    val weatherEntityData = WeatherFactory.mockWeatherEntity()
    stubGetCurrentWeatherData(Observable.just(weatherEntityData))
    val testObserver = weatherDataStore.getCurrentWeatherByCity(
      DataFactory.randomString(),
      DataFactory.randomString()
    ).test()
    testObserver.assertValue(weatherEntityData)
  }

  @Test
  fun getCurrentWeatherDataReturnsDataFromCache() {
    val weatherEntityData = WeatherFactory.mockWeatherEntity()
    stubGetCurrentWeatherData(Observable.just(weatherEntityData))
    weatherDataStore.getCurrentWeatherByCity(
      DataFactory.randomString(),
      DataFactory.randomString()
    ).test()
    verify(weatherCache).getCurrentWeather(anyLong())
  }

  @Test
  fun saveCurrentWeatherDataCompletes() {
    stubSaveWeatherData(Completable.complete())
    stubSetLastCacheTime(Completable.complete())
    val testObserver = weatherDataStore.saveCurrentWeather(WeatherFactory.mockWeatherEntity()).test()
    testObserver.assertComplete()
  }

  @Test
  fun saveCurrentWeatherDataCallsCache() {
    val weatherEntityData = WeatherFactory.mockWeatherEntity()
    stubSaveWeatherData(Completable.complete())
    stubSetLastCacheTime(Completable.complete())
    weatherDataStore.saveCurrentWeather(weatherEntityData)
    verify(weatherCache).saveCurrentWeather(weatherEntityData)
  }

  @Test
  fun clearWeatherDataCacheCompletes() {
    stubClearWeatherCache(Completable.complete())
    val testObserver = weatherDataStore.clearCurrentWeather().test()
    testObserver.assertComplete()
  }

  @Test
  fun clearWeatherDataCallsCache() {
    stubClearWeatherCache(Completable.complete())
    weatherDataStore.clearCurrentWeather().test()
    verify(weatherCache).clearCurrentWeather()
  }

  private fun stubClearWeatherCache(completable: Completable) {
    whenever(weatherCache.clearCurrentWeather())
      .thenReturn(completable)
  }

  private fun stubSaveWeatherData(completable: Completable) {
    whenever(weatherCache.saveCurrentWeather(any()))
      .thenReturn(completable)
  }

  private fun stubGetCurrentWeatherData(observable: Observable<WeatherEntity>) {
    whenever(weatherCache.getCurrentWeather(anyLong()))
      .thenReturn(observable)
  }

  private fun stubSetLastCacheTime(completable: Completable) {
    whenever(weatherCache.setLastCacheTime(anyLong(), anyLong()))
      .thenReturn(completable)
  }

}