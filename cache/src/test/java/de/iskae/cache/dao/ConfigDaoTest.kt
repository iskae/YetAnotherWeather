package de.iskae.cache.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import de.iskae.cache.db.WeatherDatabase
import de.iskae.cache.factory.ConfigDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class ConfigDaoTest {
  @Rule
  @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

  private val database = Room.inMemoryDatabaseBuilder(
    RuntimeEnvironment.application.applicationContext,
    WeatherDatabase::class.java
  )
    .allowMainThreadQueries()
    .build()

  @After
  fun cleanUp() {
    database.close()
  }

  @Test
  fun saveConfigurationSavesData() {
    val config = ConfigDataFactory.mockConfig()
    database.configDao().insertConfig(config)

    val testObserver = database.configDao().getConfig(config.id).test()
    testObserver.assertValue(config)
  }
}