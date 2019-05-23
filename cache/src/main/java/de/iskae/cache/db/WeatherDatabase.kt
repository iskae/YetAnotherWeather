package de.iskae.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.iskae.cache.dao.CachedWeatherDao
import de.iskae.cache.dao.ConfigDao
import de.iskae.cache.model.CachedWeather
import de.iskae.cache.model.Config
import javax.inject.Inject

@Database(entities = [CachedWeather::class, Config::class], version = 1)
abstract class WeatherDatabase @Inject constructor() : RoomDatabase() {

  abstract fun cachedWeatherDao(): CachedWeatherDao

  abstract fun configDao(): ConfigDao

  companion object {
    private var INSTANCE: WeatherDatabase? = null
    private var lock = Any()
    fun getInstance(context: Context): WeatherDatabase {
      if (INSTANCE == null) {
        synchronized(lock) {
          if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
              context,
              WeatherDatabase::class.java,
              WeatherConstants.DATABASE_NAME
            ).build()
          }
          return INSTANCE as WeatherDatabase
        }
      }
      return INSTANCE as WeatherDatabase
    }
  }
}