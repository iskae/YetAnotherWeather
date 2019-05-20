package de.iskae.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.DataFactory
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.mapper.WeatherDataMapper
import de.iskae.data.model.WeatherDataEntity
import de.iskae.data.repository.WeatherCache
import de.iskae.data.repository.WeatherDataStore
import de.iskae.data.store.WeatherDataStoreFactory
import de.iskae.domain.model.WeatherData
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class WeatherDataRepositoryTest {
    private val mapper = mock<WeatherDataMapper>()
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
        stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherDataEntity()))
        stubMapper(WeatherFactory.mockWeatherData(), any())

        val testObserver = repository.getCurrentWeather(DataFactory.randomString()).test()
        testObserver.assertComplete()
    }

    @Test
    fun getCurrentWeatherDataReturnsData() {
        val weatherDataEntity = WeatherFactory.mockWeatherDataEntity()
        val weatherData = WeatherFactory.mockWeatherData()
        stubGetCurrentWeatherData(Observable.just(weatherDataEntity))
        stubMapper(weatherData, weatherDataEntity)

        val testObserver = repository.getCurrentWeather(DataFactory.randomString()).test()
        testObserver.assertValue(weatherData)
    }

    private fun stubIsCurrentWeatherDataCacheExpired(single: Single<Boolean>) {
        whenever(cache.isCurrentWeatherDataCacheExpired())
            .thenReturn(single)
    }

    private fun stubIsCurrentWeatherDataCached(single: Single<Boolean>) {
        whenever(cache.isCurrentWeatherDataCached())
            .thenReturn(single)
    }

    private fun stubMapper(model: WeatherData, entity: WeatherDataEntity) {
        whenever(mapper.mapFromEntity(entity))
            .thenReturn(model)
    }

    private fun stubGetCurrentWeatherData(observable: Observable<WeatherDataEntity>) {
        whenever(store.getCurrentWeatherData())
            .thenReturn(observable)
    }

    private fun stubFactoryGetDataStore() {
        whenever(factory.getDataStore(any(), any()))
            .thenReturn(store)
    }

    private fun stubFactoryGetCacheDataStore() {
        whenever(factory.getCacheDataStore())
            .thenReturn(store)
    }

    private fun stubSaveCurrentWeatherData(completable: Completable) {
        whenever(store.saveCurrentWeatherData(any()))
            .thenReturn(completable)
    }
}