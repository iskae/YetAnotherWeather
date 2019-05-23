package de.iskae.cache.factory

import de.iskae.cache.model.Config

object ConfigDataFactory {

  fun mockConfig(): Config {
    return Config(
      id = DataFactory.randomLong(),
      lastCacheTime = DataFactory.randomLong()
    )
  }
}