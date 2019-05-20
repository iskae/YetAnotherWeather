package de.iskae.data.store

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherDataEntity
import de.iskae.data.repository.WeatherRemote
import io.reactivex.Observable
import org.junit.Test

class WeatherRemoteDataStoreTest {

    private val remote = mock<WeatherRemote>()
    private val store = WeatherRemoteDataStore(remote)

    @Test
    fun getWeatherDataCompletes() {
        stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherDataEntity()))
        val testObserver = store.getCurrentWeatherData().test()
        testObserver.assertComplete()
    }

    @Test
    fun getWeatherDataReturnsData() {
        val data = WeatherFactory.mockWeatherDataEntity()
        stubGetCurrentWeatherData(Observable.just(data))
        val testObserver = store.getCurrentWeatherData().test()
        testObserver.assertValue(data)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveCurrentWeatherDataThrowsUnsupportedOperationException() {
        store.saveCurrentWeatherData(WeatherFactory.mockWeatherDataEntity()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearCurrentWeatherDataThrowsUnsupportedOperationException() {
        store.clearCurrentWeatherData().test()
    }

    private fun stubGetCurrentWeatherData(observable: Observable<WeatherDataEntity>) {
        whenever(store.getCurrentWeatherData())
            .thenReturn(observable)
    }
}