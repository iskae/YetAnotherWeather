package de.iskae.data.store

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.data.factory.DataFactory
import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherEntity
import de.iskae.data.repository.WeatherRemote
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnit4::class)
class WeatherRemoteDataStoreTest {

    private val remote = mock<WeatherRemote>()
    private val store = WeatherRemoteDataStore(remote)

    @Test
    fun getWeatherDataCompletes() {
        stubGetCurrentWeatherData(Observable.just(WeatherFactory.mockWeatherEntity()))
        val testObserver =
            store.getCurrentWeatherByCity(
                DataFactory.randomString(),
                DataFactory.randomString()
            )
                .test()
        testObserver.assertComplete()
    }

    @Test
    fun getWeatherDataReturnsData() {
        val data = WeatherFactory.mockWeatherEntity()
        stubGetCurrentWeatherData(Observable.just(data))
        val testObserver =
            store.getCurrentWeatherByCity(
                DataFactory.randomString(),
                DataFactory.randomString()
            ).test()
        testObserver.assertValue(data)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveCurrentWeatherDataThrowsUnsupportedOperationException() {
        store.saveCurrentWeather(WeatherFactory.mockWeatherEntity()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearCurrentWeatherDataThrowsUnsupportedOperationException() {
        store.clearCurrentWeather().test()
    }

    private fun stubGetCurrentWeatherData(observable: Observable<WeatherEntity>) {
        whenever(store.getCurrentWeatherByCity(anyString(), anyString()))
            .thenReturn(observable)
    }
}