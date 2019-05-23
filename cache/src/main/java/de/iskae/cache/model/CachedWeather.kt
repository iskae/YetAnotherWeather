package de.iskae.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import de.iskae.cache.db.WeatherConstants

@Entity(tableName = WeatherConstants.TABLE_NAME)
data class CachedWeather(
  @PrimaryKey
  @ColumnInfo(name = WeatherConstants.COLUMN_WEATHER_ID)
  val id: Long,
  val name: String,
  val latitude: Double,
  val longitude: Double,
  val description: String,
  val icon: String,
  val temperature: Double,
  val pressure: Int,
  val tempMin: Double,
  val tempMax: Double,
  val windSpeed: Double,
  val windDegree: Int,
  val cloudinessPercentage: Int,
  val sunrise: Long,
  val sunset: Long
)