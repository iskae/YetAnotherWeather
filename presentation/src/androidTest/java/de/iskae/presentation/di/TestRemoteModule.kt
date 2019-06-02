package de.iskae.presentation.di

import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import de.iskae.data.repository.WeatherRemote
import de.iskae.remote.service.OpenWeatherMapService

@Module
object TestRemoteModule {

  @Provides
  @JvmStatic
  fun provideOpenWeatherMapService(): OpenWeatherMapService {
    return mock()
  }

  @Provides
  @JvmStatic
  fun provideWeatherRemote(): WeatherRemote {
    return mock()
  }

}