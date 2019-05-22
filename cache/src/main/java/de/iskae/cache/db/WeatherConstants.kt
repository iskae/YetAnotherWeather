package de.iskae.cache.db

object WeatherConstants {
  const val TABLE_NAME = "current_weather"
  const val DATABASE_NAME = "weather.db"
  const val COLUMN_WEATHER_ID = "weather_id"
  const val QUERY_WEATHER_BY_ID = "SELECT * FROM $TABLE_NAME " +
      "WHERE $COLUMN_WEATHER_ID = :weatherId"
  const val DELETE_ALL_WEATHER = "DELETE FROM $TABLE_NAME"
}