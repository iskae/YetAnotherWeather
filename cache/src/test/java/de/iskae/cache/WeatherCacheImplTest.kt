package de.iskae.cache

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import de.iskae.cache.db.WeatherDatabase
import de.iskae.cache.factory.WeatherDataFactory
import de.iskae.cache.mapper.CachedWeatherMapper
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyLong
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class WeatherCacheImplTest {

  @Rule
  @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

  private val database = Room.inMemoryDatabaseBuilder(
      RuntimeEnvironment.application,
      WeatherDatabase::class.java
  ).allowMainThreadQueries().build()

  private val mapper = CachedWeatherMapper()
  private val cache = WeatherCacheImpl(database, mapper)

  @After
  fun cleanUp() {
    database.close()
  }

  @Test
  fun saveCurrentWeatherCompletes() {
    val weatherEntity = WeatherDataFactory.mockWeatherEntity()

    val testObserver = cache.saveCurrentWeather(weatherEntity).test()
    testObserver.assertComplete()
  }

  @Test
  fun clearCurrentWeatherCompletes() {
    val testObserver = cache.clearCurrentWeather().test()
    testObserver.assertComplete()
  }

  @Test
  fun getCurrentWeatherReturnsData() {
    val currentWeatherEntity = WeatherDataFactory.mockWeatherEntity()
    cache.saveCurrentWeather(currentWeatherEntity).test()

    val testObserver = cache.getCurrentWeather(currentWeatherEntity.id).test()
    testObserver.assertValue(currentWeatherEntity)
  }

  @Test
  fun isCurrentWeatherCacheReturnsData() {
    val currentWeatherEntity = WeatherDataFactory.mockWeatherEntity()
    cache.saveCurrentWeather(currentWeatherEntity).test()

    val testObserver = cache.isCurrentWeatherCached(currentWeatherEntity.id).test()
    testObserver.assertValue(true)
  }

  @Test
  fun setLastCacheTimeCompletes() {
    val testObserver = cache.setLastCacheTime(anyLong(), anyLong()).test()
    testObserver.assertComplete()
  }

  @Test
  fun isCurrentWeatherCacheExpiredReturnsTrueWhenExpired() {
    val currentWeatherEntity = WeatherDataFactory.mockWeatherEntity()
    val testObserver = cache.isCurrentWeatherCacheExpired(currentWeatherEntity.id).test()
    testObserver.assertValue(true)
  }

  @Test
  fun isCurrentWeatherCacheExpiredReturnsFalseWhenNotExpired() {
    val currentWeatherEntity = WeatherDataFactory.mockWeatherEntity()
    cache.setLastCacheTime(currentWeatherEntity.id, System.currentTimeMillis()).test()
    val testObserver = cache.isCurrentWeatherCacheExpired(currentWeatherEntity.id).test()
    testObserver.assertValue(false)
  }
}