package de.iskae.cache.db

object ConfigConstants {
    const val TABLE_NAME = "config"
    const val CITY_ID = "city_id"
    const val QUERY_CONFIG = "SELECT * FROM $TABLE_NAME  WHERE $CITY_ID = :cityId"
}