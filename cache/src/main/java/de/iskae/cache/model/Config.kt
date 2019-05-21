package de.iskae.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.iskae.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
data class Config(
    @PrimaryKey
    var id: Long,
    var lastCacheTime: Long
)