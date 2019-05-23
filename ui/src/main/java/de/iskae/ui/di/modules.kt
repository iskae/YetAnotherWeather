package de.iskae.ui.di

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
import de.iskae.domain.repository.WeatherRepository
import de.iskae.presentation.mapper.WeatherPresentationMapper
import de.iskae.presentation.viewmodel.CurrentWeatherViewModel
import de.iskae.remote.WeatherRemoteImpl
import de.iskae.remote.mapper.WeatherResponseModelMapper
import de.iskae.remote.service.OpenWeatherMapServiceFactory
import de.iskae.ui.BuildConfig
import de.iskae.ui.UiThread
import de.iskae.ui.mapper.WeatherViewMapper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
  single { UiThread() as PostExecutionThread }
  single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
}

val dataModule = module {
  //Database
  single { WeatherDatabase.getInstance(androidContext()) }
  factory<WeatherCache> { WeatherCacheImpl(get(), get()) }

  //Mappers
  factory { WeatherMapper() }
  factory { CachedWeatherMapper() }
  factory { WeatherResponseModelMapper() }
  factory { WeatherViewMapper() }
  factory { WeatherPresentationMapper() }

  //Remote
  single { OpenWeatherMapServiceFactory().buildOpenWeatherMapService(BuildConfig.DEBUG, BuildConfig.OWM_APIKEY) }
  factory<WeatherRemote> { WeatherRemoteImpl(get(), get()) }

  //Data
  factory { WeatherCacheDataStore(get()) }
  factory { WeatherRemoteDataStore(get()) }
  factory { WeatherDataStoreFactory(get(), get()) }
  factory<WeatherRepository> { WeatherDataRepository(get(), get(), get()) }

  //Presentation
  factory { GetCurrentWeather(get(), get()) }
  viewModel { CurrentWeatherViewModel(get(), get()) }
}

