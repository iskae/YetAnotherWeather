package de.iskae.ui.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import de.iskae.cache.WeatherCacheImpl
import de.iskae.cache.db.WeatherDatabase
import de.iskae.cache.mapper.CachedWeatherMapper
import de.iskae.data.WeatherDataRepository
import de.iskae.data.mapper.WeatherMapper
import de.iskae.data.repository.WeatherCache
import de.iskae.data.repository.WeatherRemote
import de.iskae.data.store.WeatherCacheDataStore
import de.iskae.data.store.WeatherDataStoreFactory
import de.iskae.data.store.WeatherRemoteDataStore
import de.iskae.domain.executor.PostExecutionThread
import de.iskae.domain.feature.current.GetCurrentWeather
import de.iskae.presentation.mapper.WeatherPresentationMapper
import de.iskae.remote.WeatherRemoteImpl
import de.iskae.remote.mapper.WeatherResponseModelMapper
import de.iskae.remote.service.OpenWeatherMapService
import de.iskae.remote.service.OpenWeatherMapServiceFactory
import de.iskae.ui.BuildConfig
import de.iskae.ui.UiThread
import de.iskae.ui.mapper.WeatherViewMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun appModule(appContext: Context) = Kodein.Module("appModule") {
  bind<Context>() with provider { appContext }
  bind<SharedPreferences>() with provider { PreferenceManager.getDefaultSharedPreferences(appContext) }
  bind<PostExecutionThread>() with provider { UiThread() }

  import(remoteModule())
  import(cacheModule(appContext))
  import(dataModule())
  import(presentationModule())
  import(uiModule())
}

fun dataModule() = Kodein.Module("dataModule") {
  bind<WeatherMapper>() with provider { WeatherMapper() }
  bind<WeatherCacheDataStore>(tag = "cache") with provider { WeatherCacheDataStore(instance()) }
  bind<WeatherRemoteDataStore>(tag = "remote") with provider { WeatherRemoteDataStore(instance()) }
  bind<WeatherDataStoreFactory>() with provider {
    WeatherDataStoreFactory(
      instance(tag = "cache"),
      instance(tag = "remote")
    )
  }
  bind<WeatherDataRepository>() with provider { WeatherDataRepository(instance(), instance(), instance()) }
}

fun cacheModule(appContext: Context) = Kodein.Module("cacheModule") {
  bind<WeatherDatabase>() with singleton { WeatherDatabase.getInstance(appContext) }
  bind<CachedWeatherMapper>() with provider { CachedWeatherMapper() }
  bind<WeatherCache>() with provider { WeatherCacheImpl(instance(), instance()) }
}

fun presentationModule() = Kodein.Module("presentationModule") {
  bind<GetCurrentWeather>() with provider { GetCurrentWeather(instance(), instance()) }
  bind<WeatherPresentationMapper>() with provider { WeatherPresentationMapper() }
  bind<CurrentWeatherViewModelFactory>() with provider {
    CurrentWeatherViewModelFactory(instance(), instance())
  }
}

fun remoteModule() = Kodein.Module("remoteModule") {
  bind<OpenWeatherMapService>() with singleton {
    OpenWeatherMapServiceFactory().buildOpenWeatherMapService(
      BuildConfig.DEBUG,
      BuildConfig.OWM_APIKEY
    )
  }
  bind<WeatherResponseModelMapper>() with provider { WeatherResponseModelMapper() }
  bind<WeatherRemote>() with provider { WeatherRemoteImpl(instance(), instance()) }
}

fun uiModule() = Kodein.Module("uiModule") {
  bind<WeatherViewMapper>() with provider { WeatherViewMapper() }
}