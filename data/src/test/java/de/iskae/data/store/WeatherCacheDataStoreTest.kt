package de.iskae.data.store

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherCache
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Test

class WeatherCacheDataStoreTest {

    private val weatherCache = mock<WeatherCache>()
    private val weatherDataStore = WeatherCacheDataStore(weatherCache)

    @Test
    fun getCurrentWeatherDataCompletes() {
        stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherEntity()))
        val testObserver = weatherDataStore.getCurrentWeather().test()
        testObserver.assertComplete()
    }

    @Test
    fun getCurrentWeatherDataReturnsData() {
        val weatherEntityData = WeatherFactory.mockWeatherEntity()
        stubGetCurrentWeatherData(Observable.just(weatherEntityData))
        val testObserver = weatherDataStore.getCurrentWeather().test()
        testObserver.assertValue(weatherEntityData)
    }

    @Test
    fun getCurrentWeatherDataReturnsDataFromCache() {
        val weatherEntityData = WeatherFactory.mockWeatherEntity()
        stubGetCurrentWeatherData(Observable.just(weatherEntityData))
        weatherDataStore.getCurrentWeather().test()
        verify(weatherCache).getCurrentWeather()
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
        whenever(weatherCache.getCurrentWeather())
            .thenReturn(observable)
    }

    private fun stubSetLastCacheTime(completable: Completable) {
        whenever(weatherCache.setLastCacheTime(any()))
            .thenReturn(completable)
    }

}