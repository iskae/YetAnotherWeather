package de.iskae.presentation.di.module

import dagger.Binds
import dagger.Module
import de.iskae.data.WeatherDataRepository
import de.iskae.domain.repository.WeatherRepository

@Module
abstract class DataModule {
  @Binds
  abstract fun bindDataRepository(dataRepository: WeatherDataRepository): WeatherRepository
}