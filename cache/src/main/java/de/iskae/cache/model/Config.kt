package de.iskae.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import de.iskae.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
data class Config(
  @PrimaryKey
  @ColumnInfo(name = ConfigConstants.COLUMN_CITY_ID)
  var id: Long,
  var lastCacheTime: Long
)