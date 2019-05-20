package de.iskae.data.store

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test

class WeatherDataStoreFactoryTest {

    private val cacheDataStore = mock<WeatherCacheDataStore>()
    private val remoteDataStore = mock<WeatherRemoteDataStore>()
    private val factory =
        WeatherDataStoreFactory(weatherCacheDataStore = cacheDataStore, weatherRemoteDataStore = remoteDataStore)

    @Test
    fun getDataStoreReturnsRemoteDataStoreWhenCacheExpired() {
        Assert.assertEquals(remoteDataStore, factory.getDataStore(isWeatherDataCached = true, isCacheExpired = true))
    }

    @Test
    fun getDataStoreReturnsRemoteDataStoreWhenDataNotCached() {
        Assert.assertEquals(remoteDataStore, factory.getDataStore(isWeatherDataCached = false, isCacheExpired = false))
    }

    @Test
    fun getDataStoreReturnsCacheDataStoreWhenCacheIsAvailableAndNotExpired() {
        Assert.assertEquals(cacheDataStore, factory.getDataStore(isWeatherDataCached = true, isCacheExpired = false))
    }

    @Test
    fun getCacheDataStoreReturnsCacheDataStore() {
        Assert.assertEquals(cacheDataStore, factory.getCacheDataStore())
    }
}