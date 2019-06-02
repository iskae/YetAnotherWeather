package de.iskae.presentation.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import de.iskae.data.repository.WeatherRemote
import de.iskae.presentation.BuildConfig
import de.iskae.remote.WeatherRemoteImpl
import de.iskae.remote.service.OpenWeatherMapService
import de.iskae.remote.service.OpenWeatherMapServiceFactory

@Module
abstract class RemoteModule {
  @Module
  companion object {
    @Provides
    @JvmStatic
    fun provideOpenWeatherMapService(): OpenWeatherMapService {
      return OpenWeatherMapServiceFactory().buildOpenWeatherMapService(
        BuildConfig.DEBUG,
        BuildConfig.OWM_APIKEY
      )
    }
  }

  @Binds
  abstract fun bindWeatherRemote(weatherRemote: WeatherRemoteImpl): WeatherRemote
}