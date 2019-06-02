package de.iskae.presentation.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import de.iskae.domain.repository.WeatherRepository
import de.iskae.presentation.di.module.PresentationModule
import de.iskae.presentation.test.TestApplication
import javax.inject.Singleton

@Singleton
@Component(
  modules = [AndroidSupportInjectionModule::class,
    TestApplicationModule::class,
    TestCacheModule::class,
    TestDataModule::class,
    PresentationModule::class,
    TestRemoteModule::class]
)
interface TestApplicationComponent {

  fun weatherRepository(): WeatherRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): TestApplicationComponent
  }

  fun inject(application: TestApplication)

}