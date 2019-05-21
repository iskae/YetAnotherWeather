package de.iskae.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.iskae.cache.db.WeatherConstants
import de.iskae.cache.model.CachedWeather
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
abstract class CachedWeatherDao {
    @Query(WeatherConstants.QUERY_WEATHER_BY_ID)
    abstract fun getWeatherById(weatherId: Long): Maybe<CachedWeather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWeather(weather: CachedWeather): Completable

    @Query(WeatherConstants.DELETE_ALL_WEATHER)
    abstract fun deleteAllWeather()

}