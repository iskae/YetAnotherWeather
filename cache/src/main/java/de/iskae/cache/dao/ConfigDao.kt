package de.iskae.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.iskae.cache.db.ConfigConstants
import de.iskae.cache.model.Config
import io.reactivex.Maybe

@Dao
abstract class ConfigDao {
  @Query(ConfigConstants.QUERY_CONFIG)
  abstract fun getConfig(cityId: Long): Maybe<Config>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insertConfig(config: Config)
}