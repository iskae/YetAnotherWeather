package de.iskae.data.store

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherDataEntity
import de.iskae.data.repository.WeatherCache
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Test

class WeatherCacheDataStoreTest {

    private val weatherCache = mock<WeatherCache>()
    private val weatherDataStore = WeatherCacheDataStore(weatherCache)

    @Test
    fun getCurrentWeatherDataCompletes() {
        stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherDataEntity()))
        val testObserver = weatherDataStore.getCurrentWeatherData().test()
        testObserver.assertComplete()
    }

    @Test
    fun getCurrentWeatherDataReturnsData() {
        val weatherEntityData = WeatherFactory.mockWeatherDataEntity()
        stubGetCurrentWeatherData(Observable.just(weatherEntityData))
        val testObserver = weatherDataStore.getCurrentWeatherData().test()
        testObserver.assertValue(weatherEntityData)
    }

    @Test
    fun getCurrentWeatherDataReturnsDataFromCache() {
        val weatherEntityData = WeatherFactory.mockWeatherDataEntity()
        stubGetCurrentWeatherData(Observable.just(weatherEntityData))
        weatherDataStore.getCurrentWeatherData().test()
        verify(weatherCache).getCurrentWeatherData()
    }

    @Test
    fun saveCurrentWeatherDataCompletes() {
        stubSaveWeatherData(Completable.complete())
        stubSetLastCacheTime(Completable.complete())
        val testObserver = weatherDataStore.saveCurrentWeatherData(WeatherFactory.mockWeatherDataEntity()).test()
        testObserver.assertComplete()
    }

    @Test
    fun saveCurrentWeatherDataCallsCache() {
        val weatherEntityData = WeatherFactory.mockWeatherDataEntity()
        stubSaveWeatherData(Completable.complete())
        stubSetLastCacheTime(Completable.complete())
        weatherDataStore.saveCurrentWeatherData(weatherEntityData)
        verify(weatherCache).saveCurrentWeatherData(weatherEntityData)
    }

    @Test
    fun clearWeatherDataCacheCompletes() {
        stubClearWeatherCache(Completable.complete())
        val testObserver = weatherDataStore.clearCurrentWeatherData().test()
        testObserver.assertComplete()
    }

    @Test
    fun clearWeatherDataCallsCache() {
        stubClearWeatherCache(Completable.complete())
        weatherDataStore.clearCurrentWeatherData().test()
        verify(weatherCache).clearCurrentWeatherData()
    }

    private fun stubClearWeatherCache(completable: Completable) {
        whenever(weatherCache.clearCurrentWeatherData())
            .thenReturn(completable)
    }

    private fun stubSaveWeatherData(completable: Completable) {
        whenever(weatherCache.saveCurrentWeatherData(any()))
            .thenReturn(completable)
    }

    private fun stubGetCurrentWeatherData(observable: Observable<WeatherDataEntity>) {
        whenever(weatherCache.getCurrentWeatherData())
            .thenReturn(observable)
    }

    private fun stubSetLastCacheTime(completable: Completable) {
        whenever(weatherCache.setLastCacheTime(any()))
            .thenReturn(completable)
    }

}