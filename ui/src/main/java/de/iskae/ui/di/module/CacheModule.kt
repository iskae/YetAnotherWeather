package de.iskae.ui.di.module

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import de.iskae.cache.WeatherCacheImpl
import de.iskae.cache.db.WeatherDatabase
import de.iskae.data.repository.WeatherCache

@Module
abstract class CacheModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): WeatherDatabase {
            return WeatherDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindWeatherCache(weatherCache: WeatherCacheImpl): WeatherCache
}