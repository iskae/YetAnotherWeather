package de.iskae.ui.di

import android.app.Application
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import de.iskae.cache.db.WeatherDatabase
import de.iskae.data.repository.WeatherCache

@Module
object TestCacheModule {

  @Provides
  @JvmStatic
  fun provideDatabase(application: Application): WeatherDatabase {
    return WeatherDatabase.getInstance(application)
  }

  @Provides
  @JvmStatic
  fun provideWeatherCache(): WeatherCache {
    return mock()
  }

}
