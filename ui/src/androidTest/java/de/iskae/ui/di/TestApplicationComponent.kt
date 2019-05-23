package de.iskae.ui.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import de.iskae.domain.repository.WeatherRepository
import de.iskae.ui.di.module.PresentationModule
import de.iskae.ui.di.module.UiModule
import de.iskae.ui.test.TestApplication
import javax.inject.Singleton

@Singleton
@Component(
  modules = arrayOf(
    AndroidSupportInjectionModule::class,
    TestApplicationModule::class,
    TestCacheModule::class,
    TestDataModule::class,
    PresentationModule::class,
    UiModule::class,
    TestRemoteModule::class
  )
)
interface TestApplicationComponent {

  fun weatherRepository(): WeatherRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): TestApplicationComponent.Builder

    fun build(): TestApplicationComponent
  }

  fun inject(application: TestApplication)

}