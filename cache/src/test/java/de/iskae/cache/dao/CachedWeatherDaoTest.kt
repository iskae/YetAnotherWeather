package de.iskae.cache.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import de.iskae.cache.db.WeatherDatabase
import de.iskae.cache.factory.WeatherDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CachedWeatherDaoTest {

  @Rule
  @JvmField
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  private val database = Room.inMemoryDatabaseBuilder(
    RuntimeEnvironment.application,
    WeatherDatabase::class.java
  ).allowMainThreadQueries().build()

  @After
  fun cleanUp() {
    database.close()
  }

  @Test
  fun getCachedWeatherReturnsData() {
    val cachedWeather = WeatherDataFactory.mockCachedWeather()
    database.cachedWeatherDao().insertWeather(cachedWeather)

    val testObserver = database.cachedWeatherDao().getWeatherById(cachedWeather.id).test()
    testObserver.assertValue(cachedWeather)
  }

  @Test
  fun deleteAllCachedWeatherClearsData() {
    val cachedWeather = WeatherDataFactory.mockCachedWeather()
    database.cachedWeatherDao().insertWeather(cachedWeather)
    database.cachedWeatherDao().deleteAllWeather()

    val testObserver = database.cachedWeatherDao().getWeatherById(cachedWeather.id).test()
    testObserver.assertResult()
  }

}