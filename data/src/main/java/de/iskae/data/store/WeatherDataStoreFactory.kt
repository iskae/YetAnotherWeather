package de.iskae.data.store

import de.iskae.data.repository.WeatherDataStore

open class WeatherDataStoreFactory constructor(
  private val weatherCacheDataStore: WeatherCacheDataStore,
  private val weatherRemoteDataStore: WeatherRemoteDataStore
) {
  open fun getDataStore(isWeatherDataCached: Boolean, isCacheExpired: Boolean): WeatherDataStore {
    return if (isWeatherDataCached && !isCacheExpired) {
      weatherCacheDataStore
    } else {
      weatherRemoteDataStore
    }
  }

  open fun getCacheDataStore(): WeatherDataStore {
    return weatherCacheDataStore
  }
}