package de.iskae.ui.di

import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import de.iskae.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
object TestDataModule {

  @Provides
  @JvmStatic
  @Singleton
  fun provideDataRepository(): WeatherRepository {
    return mock()
  }

}